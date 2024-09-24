package org.SchoolApp.Filters;


import jakarta.servlet.http.HttpServletResponseWrapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.io.IOException;

public class RestResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Wrap the response to capture the output
        CharResponseWrapper responseWrapper = new CharResponseWrapper((HttpServletResponse) response);

        // Proceed with the next filter or target resource
        chain.doFilter(request, responseWrapper);

        // Get the original response body
        String originalResponse = responseWrapper.getCaptureAsString();

        // Get the status code
        int statusCode = responseWrapper.getStatus();

        // Format the response (example structure)
        String formattedResponse = String.format("{\"status\": %d, \"data\": %s, \"message\": \"\"}", statusCode, originalResponse.isEmpty() ? "null" : originalResponse);

        // Set the response content type and write the formatted response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(formattedResponse);
        out.flush();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

    // Inner class to capture the response body
    private class CharResponseWrapper extends HttpServletResponseWrapper {
        private StringWriter writer = new StringWriter();

        public CharResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(writer);
        }

        public String getCaptureAsString() {
            return writer.toString();
        }
    }
}
