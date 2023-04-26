package rh.javapleno.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UrlPathfilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
        return requestURI.matches("/v3/api-docs/.+");
    }

    public Object run() {
        String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();

        String servicePattern = "/v3/api-docs/(?<group>.+)";
        Pattern compile = Pattern.compile(servicePattern);
        Matcher matcher = compile.matcher (requestURI);

        String group = "";
        while (matcher.find()) {
            group = matcher.group("group");
        }

        String path = "/" + group + "/v3/api-docs";

        RequestContext context =  RequestContext.getCurrentContext();
        context.put(FilterConstants.REQUEST_URI_KEY, path);
        return null;
    }
}

