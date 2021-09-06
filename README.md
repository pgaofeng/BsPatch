# BsPatch

使用`bsdiff-4.3`版本，`bzip2-1.0.6`版本

测试步骤：

1. 根据`bsdiff-4.3`和`bzip-1.0.6`编译出`bsdiff`。
2. 使用`as`打包出两个版本的`apk`，并安装运行旧版本
3. 使用`./bsdiff old.apk new.apk patch`命令产生`patch`差分文件
4. 将`patch`复制到`Android/data/com.study.bspatch/cache`目录
5. 运行旧版本，点击更新即可生成新包`output.apk`

