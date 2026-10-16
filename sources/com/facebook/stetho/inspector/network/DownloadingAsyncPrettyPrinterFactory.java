package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class MatchResult {
        private final PrettyPrinterDisplayType mDisplayType;
        private final String mSchemaUri;

        public MatchResult(String str, PrettyPrinterDisplayType prettyPrinterDisplayType) {
            this.mSchemaUri = str;
            this.mDisplayType = prettyPrinterDisplayType;
        }

        public PrettyPrinterDisplayType getDisplayType() {
            return this.mDisplayType;
        }

        public String getSchemaUri() {
            return this.mSchemaUri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Request implements Callable<String> {
        private URL url;

        public Request(URL url) {
            this.url = url;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    return Util.readAsUTF8(inputStream);
                } finally {
                    inputStream.close();
                }
            }
            throw new IOException("Got status code: " + responseCode + " while downloading schema with url: " + this.url.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doErrorPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException {
        printWriter.print(str + "\n" + Util.readAsUTF8(inputStream));
    }

    private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(final String str, final String str2) {
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.2
            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return PrettyPrinterDisplayType.TEXT;
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "[Failed to parse header: " + str + " : " + str2 + " ]");
            }
        };
    }

    @Nullable
    private static URL parseURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    protected abstract void doPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException;

    @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinterFactory
    public AsyncPrettyPrinter getInstance(String str, String str2) {
        final MatchResult matchResultMatchAndParseHeader = matchAndParseHeader(str, str2);
        if (matchResultMatchAndParseHeader == null) {
            return null;
        }
        URL url = parseURL(matchResultMatchAndParseHeader.getSchemaUri());
        if (url == null) {
            return getErrorAsyncPrettyPrinter(str, str2);
        }
        ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (executorService == null) {
            return null;
        }
        final Future futureSubmit = executorService.submit(new Request(url));
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.1
            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return matchResultMatchAndParseHeader.getDisplayType();
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                try {
                    try {
                        try {
                            DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) futureSubmit.get());
                        } catch (InterruptedException e3) {
                            DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Encountered spurious interrupt while downloading schema for pretty printing: " + e3.getMessage());
                        }
                    } catch (ExecutionException e4) {
                        if (!IOException.class.isInstance(e4.getCause())) {
                            throw e4;
                        }
                        DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Cannot successfully download schema: " + e4.getMessage());
                    }
                } catch (ExecutionException e5) {
                    throw ExceptionUtil.propagate(e5.getCause());
                }
            }
        };
    }

    @Nullable
    protected abstract MatchResult matchAndParseHeader(String str, String str2);
}
