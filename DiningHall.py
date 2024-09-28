import threading

# Contadores protegidos por mutex
eating = 0
readyToLeave = 0

# Semáforos
mutex = threading.Semaphore(1)
okToLeave = threading.Semaphore(0)

def get_food():
    global eating, readyToLeave
    
    mutex.acquire()
    eating += 1
    if eating == 2 and readyToLeave == 1:
        okToLeave.release()
        readyToLeave -= 1
    mutex.release()

def dine():
    print(f'Student is dining...')

def leave():
    print(f'Student has left the dining hall.')

def student():
    global eating, readyToLeave
    
    get_food()
    dine()
    
    mutex.acquire()
    eating -= 1
    readyToLeave += 1

    if eating == 1 and readyToLeave == 1:
        mutex.release()
        okToLeave.acquire()
    elif eating == 0 and readyToLeave == 2:
        okToLeave.release()
        readyToLeave -= 2
        mutex.release()
    else:
        readyToLeave -= 1
        mutex.release()
    
    leave()

# Testando com múltiplos estudantes
threads = []
for i in range(5):
    t = threading.Thread(target=student)
    threads.append(t)
    t.start()

for t in threads:
    t.join()
