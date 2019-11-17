# 开发环境
- idea 2018.3 64bit
- jdk8 64bit
- maven 3.3.9 64bit
- mysql8.0

# 开发版本管理
master<-dev<-dev-idea/dev-sts

# 授权码测试
## 步骤
1. 导入sql 
2. 启动三个子项目
3. 模拟A用户访问客户端client: http://localhost:10000/client/index
4. 输入A用户在resources中的username，password，都是a
5. 接着会直接跳转会client主页，此时可以直接访问resource资源

## 说明
如果使用中重启了client，或者使用上一次的code，可能会导致bug，此bug待解决