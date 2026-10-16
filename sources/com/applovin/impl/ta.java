package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ta extends dk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f63916c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f63917a = Charsets.UTF_8.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f63918b = Charsets.ISO_8859_1.newDecoder();

    @Override // com.applovin.impl.dk
    protected af a(df dfVar, ByteBuffer byteBuffer) {
        String strA = a(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strA == null) {
            return new af(new va(bArr, null, null));
        }
        Matcher matcher = f63916c.matcher(strA);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String lowerCase = Ascii.toLowerCase(strGroup);
                lowerCase.getClass();
                if (lowerCase.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (lowerCase.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new af(new va(bArr, str, str2));
    }

    private String a(ByteBuffer byteBuffer) {
        try {
            return this.f63917a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.f63918b.decode(byteBuffer).toString();
                this.f63918b.reset();
                byteBuffer.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.f63918b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f63918b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f63917a.reset();
            byteBuffer.rewind();
        }
    }
}
