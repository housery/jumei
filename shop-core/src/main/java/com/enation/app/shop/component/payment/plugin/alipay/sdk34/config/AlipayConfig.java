package com.enation.app.shop.component.payment.plugin.alipay.sdk34.config;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092300580446";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCSKxZGsxDlhkfhVSsw6bEV3JUT5VV0Q9G+I0NL55/bDdb7OnuKYNv6wN4Iw23oB/S0jNyKoUDFbDlgRF9ksH+is1bQhM9Dxtvt44RLc4pQzusCOdcZDrwp0vUVTHsVC/yb1Y1FdLxrKpykYr7gaY2g6U7P2yQ0F7mqU/Qy6a2Xl+9FC2R3WFjsfecWFb+WiIEVE2nf6bu+ZfaIx43F3hof4FP9e/CuzP96n5dWaxtRv6r66hZmmcITBmFSXXkuZe4WDsgAtZL3DGOs0SDVowmErxKCXampv+qknwN8zRsOZFQEPxoLZdF9AatYXHKaRf1gwsYAFm3ZltZWuPKTkDkRAgMBAAECggEAYyWC2LYB0g7BlyEUSPtbOT8EiBhZXKHcFaMJtOUKU6YRmxvSTMziqjZE5aDaXjd3Tzj1J7u1mbSNPrViF4R5Lz2Ct7I+fPTYnYZkaGGZArM4Saw+MSsDi0MjJy1Xl7EnyfSS/PfwDqk6025/lu1COlHHOcqlxggJ0nVcAWTscRR4mRwclIIeJRguFbcTIDZP/jPJdivLMSK9mbRM4mRkhVrIFrOrjLXIXbV5iQFbIk//ZRKRSzDklD0/3G1HSbiW2VJ2uWjXIrM95bpK59mWKvUWe8VTrcCVZD166DkdBkn6FUbwV45GXfcXtRHvBWHAJWbgeYPqO47mZq9kKWBXWQKBgQD7kJj9TSvzAgAY8UvwW1B3uvxEw+QYjq+/0dI2TyG3oIqFI8AM1pgBaDe50CJBR+U42iHaeEBuJwVyMdhhLUycg8yzM12YGYvuU62XQqWoFWOUKka9C63aZL6FYdjvYQkemASbvUbyYlHawdj3bqVEi77NtzFLY51I4QW7pQbO7wKBgQCUvswLsGIT2L21jezUVnMV8AbcchXSv5bNG6I0bGubayA+QzOIWN+DxS6AOtb0QRiqSAXIGcfLMNs8lZDgudc3XpU8zZ9irOJXpoMv0TpGDfEJwj9maLhKEBAKtoJksT5SEjaRbtOpmp1yPEafPFjJSLQBIMEWEi4zDLIsUdl3/wKBgCoHJVgkPXRy4BtKrNoyF0Z5ic3fQEtOA1SztD/4hnSMMLg/mcVLUMfjZnP3rtFjNouB/efm8TS19jX21+ScUdFQP7GsojVYB0XA2x6LNuvW7vUA/yJ0Qg5biGz2ROzxNDnVQefW/nReMriubBYieR/zjOQHeAfVU6CqX2/TCUknAoGAWfBgGnVFaHC2jO/LEr1PCyW+UE8fSPYVreGWm5IvIqOMtHkX0MrEI733lwt86+XsjxHLhSmpeAALoD9jga59JnqnTEOcqyKUHaGOUzx0uuU1KMxuX3LUc9vwhznB8DaH00I2Aov7qeLWbrtpjGEF4nd2d/QhLEJD8xQrK8c18msCgYBb6B+cdr4VNo5ibXAyBRGiaPS2PRopsg1CiAUbxXX1mPjo9L6cEJwJEIMWW0iMpTy9DyaUu8VyqDiZmbfQ0YPME5NiZuUQB1ZxhLRlwI1UID9pD/E6wuLwqFwWillBEAR6MhJ0lmuBABmqi8SenTY8xBQZdpO7KBzXYEaXRjMgUw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkisWRrMQ5YZH4VUrMOmxFdyVE+VVdEPRviNDS+ef2w3W+zp7imDb+sDeCMNt6Af0tIzciqFAxWw5YERfZLB/orNW0ITPQ8bb7eOES3OKUM7rAjnXGQ68KdL1FUx7FQv8m9WNRXS8ayqcpGK+4GmNoOlOz9skNBe5qlP0Mumtl5fvRQtkd1hY7H3nFhW/loiBFRNp3+m7vmX2iMeNxd4aH+BT/Xvwrsz/ep+XVmsbUb+q+uoWZpnCEwZhUl15LmXuFg7IALWS9wxjrNEg1aMJhK8Sgl2pqb/qpJ8DfM0bDmRUBD8aC2XRfQGrWFxymkX9YMLGABZt2ZbWVrjyk5A5EQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	

}

