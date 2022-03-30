package cn.yinjiahui.group_purchase.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class HttpConfig {

    @Bean
    public CloseableHttpClient httpClient() throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            // 信任所有
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();


        // ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"}, null,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        return httpclient;
    }

}
