package com.evernote.android.job.util.support;

import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class FastXmlSerializer implements XmlSerializer {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f67969k = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f67970l = "                                                              ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f67972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Writer f67973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OutputStream f67974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharsetEncoder f67975e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f67978h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f67971a = new char[Utility.DEFAULT_STREAM_BUFFER_SIZE];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f67976f = ByteBuffer.allocate(Utility.DEFAULT_STREAM_BUFFER_SIZE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f67977g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f67979i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f67980j = true;

    FastXmlSerializer() {
    }

    private void a(char c3) throws IOException {
        int i3 = this.f67972b;
        if (i3 >= 8191) {
            flush();
            i3 = this.f67972b;
        }
        this.f67971a[i3] = c3;
        this.f67972b = i3 + 1;
    }

    private void b(String str) throws IOException {
        c(str, 0, str.length());
    }

    private void c(String str, int i3, int i4) throws IOException {
        if (i4 > 8192) {
            int i5 = i4 + i3;
            while (i3 < i5) {
                int i6 = i3 + Utility.DEFAULT_STREAM_BUFFER_SIZE;
                c(str, i3, i6 < i5 ? 8192 : i5 - i3);
                i3 = i6;
            }
            return;
        }
        int i7 = this.f67972b;
        if (i7 + i4 > 8192) {
            flush();
            i7 = this.f67972b;
        }
        str.getChars(i3, i3 + i4, this.f67971a, i7);
        this.f67972b = i7 + i4;
    }

    private void d(char[] cArr, int i3, int i4) throws IOException {
        if (i4 > 8192) {
            int i5 = i4 + i3;
            while (i3 < i5) {
                int i6 = i3 + Utility.DEFAULT_STREAM_BUFFER_SIZE;
                d(cArr, i3, i6 < i5 ? 8192 : i5 - i3);
                i3 = i6;
            }
            return;
        }
        int i7 = this.f67972b;
        if (i7 + i4 > 8192) {
            flush();
            i7 = this.f67972b;
        }
        System.arraycopy(cArr, i3, this.f67971a, i7, i4);
        this.f67972b = i7 + i4;
    }

    private void e(int i3) throws IOException {
        int length = i3 * 4;
        if (length > f67970l.length()) {
            length = f67970l.length();
        }
        c(f67970l, 0, length);
    }

    private void f(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f67969k;
        char length2 = (char) strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < length2 && (str2 = strArr[cCharAt]) != null) {
                if (i4 < i3) {
                    c(str, i4, i3 - i4);
                }
                i4 = i3 + 1;
                b(str2);
            }
            i3++;
        }
        if (i4 < i3) {
            c(str, i4, i3 - i4);
        }
    }

    private void g(char[] cArr, int i3, int i4) throws IOException {
        String str;
        String[] strArr = f67969k;
        char length = (char) strArr.length;
        int i5 = i4 + i3;
        int i6 = i3;
        while (i3 < i5) {
            char c3 = cArr[i3];
            if (c3 < length && (str = strArr[c3]) != null) {
                if (i6 < i3) {
                    d(cArr, i6, i3 - i6);
                }
                i6 = i3 + 1;
                b(str);
            }
            i3++;
        }
        if (i6 < i3) {
            d(cArr, i6, i3 - i6);
        }
    }

    private void h() throws IOException {
        int iPosition = this.f67976f.position();
        if (iPosition > 0) {
            this.f67976f.flip();
            this.f67974d.write(this.f67976f.array(), 0, iPosition);
            this.f67976f.clear();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        a(' ');
        if (str != null) {
            b(str);
            a(':');
        }
        b(str2);
        b("=\"");
        f(str3);
        a('\"');
        this.f67980j = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        int i3 = this.f67979i - 1;
        this.f67979i = i3;
        if (this.f67978h) {
            b(" />\n");
        } else {
            if (this.f67977g && this.f67980j) {
                e(i3);
            }
            b("</");
            if (str != null) {
                b(str);
                a(':');
            }
            b(str2);
            b(">\n");
        }
        this.f67980j = true;
        this.f67978h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i3 = this.f67972b;
        if (i3 > 0) {
            if (this.f67974d != null) {
                CharBuffer charBufferWrap = CharBuffer.wrap(this.f67971a, 0, i3);
                CoderResult coderResultEncode = this.f67975e.encode(charBufferWrap, this.f67976f, true);
                while (!coderResultEncode.isError()) {
                    if (coderResultEncode.isOverflow()) {
                        h();
                        coderResultEncode = this.f67975e.encode(charBufferWrap, this.f67976f, true);
                    } else {
                        h();
                        this.f67974d.flush();
                    }
                }
                throw new IOException(coderResultEncode.toString());
            }
            this.f67973c.write(this.f67971a, 0, i3);
            this.f67973c.flush();
            this.f67972b = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z2) {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
        this.f67977g = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f67975e = Charset.forName(str).newEncoder();
            this.f67974d = outputStream;
        } catch (IllegalCharsetNameException e3) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
        } catch (UnsupportedCharsetException e4) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e4));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        b(sb.toString());
        this.f67980j = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        if (this.f67978h) {
            b(">\n");
        }
        if (this.f67977g) {
            e(this.f67979i);
        }
        this.f67979i++;
        a('<');
        if (str != null) {
            b(str);
            a(':');
        }
        b(str2);
        this.f67978h = true;
        this.f67980j = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i3, int i4) throws IOException {
        if (this.f67978h) {
            b(">");
            this.f67978h = false;
        }
        g(cArr, i3, i4);
        if (this.f67977g) {
            this.f67980j = cArr[(i3 + i4) - 1] == '\n';
        }
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        boolean z2 = false;
        if (this.f67978h) {
            b(">");
            this.f67978h = false;
        }
        f(str);
        if (this.f67977g) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == '\n') {
                z2 = true;
            }
            this.f67980j = z2;
        }
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.f67973c = writer;
    }
}
