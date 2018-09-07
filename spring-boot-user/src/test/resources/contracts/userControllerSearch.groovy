package contracts

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    request {
        method 'GET'
        url '/v001/user/search'
        headers {
            header('Content-Type', 'text/plain')
        }
    }
    response {
        status 200
        body("""
{"name":"peter"}
  """)
        headers {
//            header('Content-Type': 'application/json[;charset=UTF-8]')
        }
    }
}