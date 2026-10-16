package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f144851e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f144852f = {42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List f144853g = CollectionsKt.listOf("*");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PublicSuffixDatabase f144854h = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f144855a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f144856b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f144857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f144858d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i3) {
            int i4;
            int iD;
            boolean z2;
            int iD2;
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != 10) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i4 = i7 + i8;
                    if (bArr[i4] == 10) {
                        break;
                    }
                    i8++;
                }
                int i9 = i4 - i7;
                int i10 = i3;
                boolean z3 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z3) {
                        iD = 46;
                        z2 = false;
                    } else {
                        boolean z4 = z3;
                        iD = Util.d(bArr2[i10][i11], 255);
                        z2 = z4;
                    }
                    iD2 = iD - Util.d(bArr[i7 + i12], 255);
                    if (iD2 != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z3 = z2;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z3 = true;
                        i11 = -1;
                    }
                }
                if (iD2 >= 0) {
                    if (iD2 <= 0) {
                        int i13 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        int length3 = bArr2.length;
                        for (int i14 = i10 + 1; i14 < length3; i14++) {
                            length2 += bArr2[i14].length;
                        }
                        if (length2 >= i13) {
                            if (length2 <= i13) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i7, i9, UTF_8);
                            }
                        }
                    }
                    i5 = i4 + 1;
                }
                length = i6;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f144854h;
        }

        private Companion() {
        }
    }

    private final List b(List list) {
        String str;
        String str2;
        String strB;
        if (this.f144855a.get() || !this.f144855a.compareAndSet(false, true)) {
            try {
                this.f144856b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (this.f144857c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i3 = 0; i3 < size; i3++) {
            String str3 = (String) list.get(i3);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str3.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i3] = bytes;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                str = null;
                break;
            }
            int i5 = i4 + 1;
            Companion companion = f144851e;
            byte[] bArr2 = this.f144857c;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr2 = null;
            }
            String strB2 = companion.b(bArr2, bArr, i4);
            if (strB2 != null) {
                str = strB2;
                break;
            }
            i4 = i5;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                bArr3[i6] = f144852f;
                Companion companion2 = f144851e;
                byte[] bArr4 = this.f144857c;
                if (bArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr4 = null;
                }
                String strB3 = companion2.b(bArr4, bArr3, i6);
                if (strB3 != null) {
                    str2 = strB3;
                    break;
                }
                i6 = i7;
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i8 = size - 1;
            int i9 = 0;
            while (i9 < i8) {
                int i10 = i9 + 1;
                Companion companion3 = f144851e;
                byte[] bArr5 = this.f144858d;
                if (bArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                strB = companion3.b(bArr5, bArr, i9);
                if (strB != null) {
                    break;
                }
                i9 = i10;
            }
            strB = null;
        } else {
            strB = null;
        }
        if (strB != null) {
            return StringsKt.U0(Intrinsics.stringPlus("!", strB), new char[]{'.'}, false, 0, 6, null);
        }
        if (str == null && str2 == null) {
            return f144853g;
        }
        List listU0 = str == null ? null : StringsKt.U0(str, new char[]{'.'}, false, 0, 6, null);
        if (listU0 == null) {
            listU0 = CollectionsKt.emptyList();
        }
        List listU02 = str2 != null ? StringsKt.U0(str2, new char[]{'.'}, false, 0, 6, null) : null;
        if (listU02 == null) {
            listU02 = CollectionsKt.emptyList();
        }
        return listU0.size() > listU02.size() ? listU0 : listU02;
    }

    private final void d() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource bufferedSourceD = Okio.d(new GzipSource(Okio.l(resourceAsStream)));
        try {
            byte[] bArrS0 = bufferedSourceD.S0(bufferedSourceD.readInt());
            byte[] bArrS02 = bufferedSourceD.S0(bufferedSourceD.readInt());
            Unit unit = Unit.f139807a;
            CloseableKt.a(bufferedSourceD, null);
            synchronized (this) {
                Intrinsics.checkNotNull(bArrS0);
                this.f144857c = bArrS0;
                Intrinsics.checkNotNull(bArrS02);
                this.f144858d = bArrS02;
            }
            this.f144856b.countDown();
        } finally {
        }
    }

    private final void e() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e3) {
                    Platform.f144818a.g().k("Failed to read public suffix list", 5, e3);
                    if (!z2) {
                        return;
                    }
                }
            } finally {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private final List f(String str) {
        List listU0 = StringsKt.U0(str, new char[]{'.'}, false, 0, 6, null);
        return Intrinsics.areEqual(CollectionsKt.last(listU0), "") ? CollectionsKt.dropLast(listU0, 1) : listU0;
    }

    public final String c(String domain) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List listF = f(unicodeDomain);
        List listB = b(listF);
        if (listF.size() == listB.size() && ((String) listB.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listB.get(0)).charAt(0) == '!') {
            size = listF.size();
            size2 = listB.size();
        } else {
            size = listF.size();
            size2 = listB.size() + 1;
        }
        return SequencesKt.K(SequencesKt.w(CollectionsKt.asSequence(f(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
