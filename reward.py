import random as ran

ran100 = range(100)
relax = ran.choice(ran100)
ninja_3 = ran.choice(ran100)
video = ran.choice(ran100)
penalty = ran.choice(ran100)

if relax in range(0, 25):
    if video in range(0, 10):
        print('看一集电影 2h')
    elif video in range(10, 55):
        print('追一集番 30min')
    elif video in range(55, 100):
        print('看3集UP主上传视频')
elif relax in range(25, 50):
    print('忍三，30min，不满意就再抽一次')
elif relax in range(50, 100):
    if penalty in range(0, 50):
        print('十个俯卧撑并再抽一次')
    elif penalty in range(50, 100):
        print('30个仰卧起坐并再抽一次')

study = ran.choice(range(100))
if study in range(0, 33):
    print("TOEFL")
elif study in range(33, 66):
    print("CS210")
elif study in range(66, 99):
    print("Rust")
else:
    print("Once Again")
