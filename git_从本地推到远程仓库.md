### git从本地推到远程仓库
* cd 到本地项目根目录,创建并初始化git仓库 ：git init 
* 将项目的所有文件添加到仓库中 git add . (如果想添加某个特定的文件，把.换成特定的文件名)
* 将add的文件commit 到仓库：git commit -m "注释语句"
* 将本地仓库关联到github: git remote add origin url
* 上传之前先更新：git pull origin master
  注意：更新可能会报错：fatal: refusing to merge unrelated histories
        解决办法：git pull origin branchname --allow-unrelated-histories
        弹出提示框：please enter....
        1.按键盘字母 i 进入insert模式

        2.修改最上面那行黄色合并信息,可以不修改

        3.按键盘左上角"Esc"

        4.输入":wq",注意是冒号+wq,按回车键即可

* 上传：git push -u origin master


