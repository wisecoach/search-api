# Search斯尔奇人才管理系统

## 注意事项
1. 这个版本是用来放在search.zjnu404.xyz上的版本，如果要本地使用需要修改一些参数
    1. application-dev.yaml中的最下面的四个参数
    2. CorsConfig中AllowOrigin修改为你前端的域名，注意，前端必须为同一站点，即只有端口不一样，否则Google浏览器是不能用的，这个是我们没办法的
    3. FileTypeEnum中的url也要修改为你的后端域名
