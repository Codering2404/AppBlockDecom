package com.applovin.impl;

import android.util.Xml;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f59824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Stack f59825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f59826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f59827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f59828e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b extends es {
        b(String str, Map map, es esVar) {
            super(str, map, esVar);
        }

        void a(es esVar) {
            if (esVar == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.f59551e.add(esVar);
        }

        void d(String str) {
            this.f59550d = str;
        }
    }

    fs(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f59824a = jVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map a(Attributes attributes) {
        if (attributes != null) {
            int length = attributes.getLength();
            HashMap map = new HashMap(length);
            for (int i3 = 0; i3 < length; i3++) {
                map.put(attributes.getQName(i3), attributes.getValue(i3));
            }
            return map;
        }
        return Collections.EMPTY_MAP;
    }

    public es a(String str) throws SAXException {
        if (str != null) {
            this.f59826c = new StringBuilder();
            this.f59825b = new Stack();
            this.f59828e = null;
            Xml.parse(str, new a());
            b bVar = this.f59828e;
            if (bVar != null) {
                return bVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }

    public static es a(String str, com.applovin.impl.sdk.j jVar) {
        return new fs(jVar).a(str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ContentHandler {
        a() {
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i4) {
            String strTrim = new String(Arrays.copyOfRange(cArr, i3, i4)).trim();
            if (StringUtils.isValidString(strTrim)) {
                fs.this.f59826c.append(strTrim);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - fs.this.f59827d;
            com.applovin.impl.sdk.n unused = fs.this.f59824a;
            if (com.applovin.impl.sdk.n.a()) {
                fs.this.f59824a.a("XmlParser", "Finished parsing in " + seconds + " seconds");
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            fs fsVar = fs.this;
            fsVar.f59828e = (b) fsVar.f59825b.pop();
            fs.this.f59828e.d(fs.this.f59826c.toString().trim());
            fs.this.f59826c.setLength(0);
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
            com.applovin.impl.sdk.n unused = fs.this.f59824a;
            if (com.applovin.impl.sdk.n.a()) {
                fs.this.f59824a.a("XmlParser", "Begin parsing...");
            }
            fs.this.f59827d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            try {
                b bVar = !fs.this.f59825b.isEmpty() ? (b) fs.this.f59825b.peek() : null;
                b bVar2 = new b(str2, fs.this.a(attributes), bVar);
                if (bVar != null) {
                    bVar.a(bVar2);
                }
                fs.this.f59825b.push(bVar2);
            } catch (Exception e3) {
                com.applovin.impl.sdk.n unused = fs.this.f59824a;
                if (com.applovin.impl.sdk.n.a()) {
                    fs.this.f59824a.a("XmlParser", "Unable to process element <" + str2 + ">", e3);
                }
                throw new SAXException("Failed to start element", e3);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i3, int i4) {
        }
    }
}
