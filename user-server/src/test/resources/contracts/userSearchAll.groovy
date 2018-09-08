import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url('/v001/user/searchAll')
    }
    response {
        status 200
        body("""
{"success":true,"data":[{"uid":1,"username":"admin","name":"管理员","password":"d3c59d25033dbf980d29554025c23a75","salt":"8d78869f470951332959580424d4bf4f","state":0,"credentialsSalt":"admin8d78869f470951332959580424d4bf4f"},{"uid":2,"username":"admi","name":"peter","password":"d3c59d25033dbf980d29554025c23a75","salt":"8d78869f470951332959580424d4bf4f","state":2,"credentialsSalt":"admi8d78869f470951332959580424d4bf4f"},{"uid":3,"username":"我是新加的昵称","name":"我是新加的姓名","password":"d3c59d25033dbf980d29554025c23a75","salt":"8d78869f470951332959580424d4bf4f","state":1,"credentialsSalt":"我是新加的昵称8d78869f470951332959580424d4bf4f"},{"uid":5,"username":"我是新加的昵称1","name":"我是新加的姓名1","password":"d3c59d25033dbf980d29554025c23a75","salt":"8d78869f470951332959580424d4bf4f","state":1,"credentialsSalt":"我是新加的昵称18d78869f470951332959580424d4bf4f"}]}  """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}