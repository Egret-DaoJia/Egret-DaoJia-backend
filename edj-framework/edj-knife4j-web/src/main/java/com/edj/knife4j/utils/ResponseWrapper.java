package com.edj.knife4j.utils;


import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.*;

/**
 * 重写response返回值
 *
 * @author A.E.
 * @date 2024/10/8
 */
public class ResponseWrapper extends HttpServletResponseWrapper {
    private final ByteArrayOutputStream buffer;
    private final ServletOutputStream out;
    private final PrintWriter writer;

    public ResponseWrapper(HttpServletResponse resp) throws IOException {
        super(resp);
        buffer = new ByteArrayOutputStream();// 真正存储数据的流
        out = new WrappedOutputStream(buffer);
        writer = new PrintWriter(new OutputStreamWriter(buffer));
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return out;
    }

    @Override
    public PrintWriter getWriter() throws UnsupportedEncodingException {
        return writer;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (out != null) {
            out.flush();
        }
        if (writer != null) {
            writer.flush();
        }
    }

    @Override
    public void reset() {
        buffer.reset();
    }

    public byte[] getResponseData() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }

    public String getContent() throws IOException {
        flushBuffer();
        return buffer.toString();
    }

    private static class WrappedOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream bos = null;

        public WrappedOutputStream(ByteArrayOutputStream stream) throws IOException {
            bos = stream;
        }

        @Override
        public void write(int b) throws IOException {
            bos.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            bos.write(b, 0, b.length);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            bos.write(b, off, len);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }
    }
}