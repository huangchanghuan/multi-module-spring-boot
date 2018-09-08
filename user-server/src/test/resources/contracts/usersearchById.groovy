import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url('/v001/user/searchById') {
            queryParameters {
                parameter("uid", "1")
            }
        }

    }
    response {
        status 200
        body("""
{"success":true,"data":{"username":"admin","password":"d3c59d25033dbf980d29554025c23a75","state":0,"credentialsSalt":"adminnull"}}
  """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}