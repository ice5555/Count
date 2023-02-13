## 软件安装说明

* 前端安装

  * 使用 Nginx 进行配置，使得客户端请求能够正确转发到前端项目。

  * 修改Nginx配置文件

    ```c
    server {
        
    	listen  8080;#自己设置端口号
        server_name  localhost;#自己设置项目名称
        #access_log  logs/host.access.log  main;
        location / {
            root   /root/Count/webapp/dist;#这里写vue项目的所在地址
            index  index.html;#这里是vue项目的首页，需要保证dist中有index.html文件
        }
        error_page   500 502 503 504  /50x.html;#错误页面
     	location /user/ {
        #开启重写日志记录，这个会记录在error.log里面，级别为notice
        rewrite_log on;
        #重写规则，可根据实际情况调整。
        rewrite ^/api/(.*)$ /$1 break;
        proxy_pass http://localhost:8888;
        proxy_redirect    off;
        proxy_set_header  Host $host;
        proxy_set_header  X-real-ip $remote_addr;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        }
        location /api/home/ {
        #开启重写日志记录，这个会记录在error.log里面，级别为notice
        rewrite_log on;
        #重写规则，可根据实际情况调整。
        rewrite ^/api/home/(.*)$ /api/home/$1 break;
        proxy_pass http://localhost:8888/api/home/;
        proxy_redirect    off;
        proxy_set_header  Host $host;
        proxy_set_header  X-real-ip $remote_addr;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
    }
       
    }
    ```

  * 重新加载Nginx

    ```
    nginx -s reload
    ```

    

* 后端安装

  ```
   java -jar server-2.3.7.RELEASE.jar 
  ```

  