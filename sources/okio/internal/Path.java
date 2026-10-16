package okio.internal;

import com.facebook.FacebookContentProvider;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: renamed from: okio.internal.-Path, reason: invalid class name */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Path {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f145160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f145161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ByteString f145162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ByteString f145163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ByteString f145164e;

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f145160a = companion.d("/");
        f145161b = companion.d("\\");
        f145162c = companion.d("/\\");
        f145163d = companion.d(".");
        f145164e = companion.d(FacebookContentProvider.INVALID_FILE_NAME);
    }

    public static final okio.Path j(okio.Path path, okio.Path child, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.n() != null) {
            return child;
        }
        ByteString byteStringM = m(path);
        if (byteStringM == null && (byteStringM = m(child)) == null) {
            byteStringM = s(okio.Path.f145074c);
        }
        Buffer buffer = new Buffer();
        buffer.q2(path.b());
        if (buffer.size() > 0) {
            buffer.q2(byteStringM);
        }
        buffer.q2(child.b());
        return q(buffer, z2);
    }

    public static final okio.Path k(String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return q(new Buffer().C0(str), z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(okio.Path path) {
        int iT = ByteString.t(path.b(), f145160a, 0, 2, null);
        return iT != -1 ? iT : ByteString.t(path.b(), f145161b, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString m(okio.Path path) {
        ByteString byteStringB = path.b();
        ByteString byteString = f145160a;
        if (ByteString.o(byteStringB, byteString, 0, 2, null) != -1) {
            return byteString;
        }
        ByteString byteStringB2 = path.b();
        ByteString byteString2 = f145161b;
        if (ByteString.o(byteStringB2, byteString2, 0, 2, null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(okio.Path path) {
        return path.b().f(f145164e) && (path.b().C() == 2 || path.b().w(path.b().C() + (-3), f145160a, 0, 1) || path.b().w(path.b().C() + (-3), f145161b, 0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(okio.Path path) {
        if (path.b().C() == 0) {
            return -1;
        }
        if (path.b().g(0) == 47) {
            return 1;
        }
        if (path.b().g(0) == 92) {
            if (path.b().C() <= 2 || path.b().g(1) != 92) {
                return 1;
            }
            int iM = path.b().m(f145161b, 2);
            return iM == -1 ? path.b().C() : iM;
        }
        if (path.b().C() > 2 && path.b().g(1) == 58 && path.b().g(2) == 92) {
            char cG = (char) path.b().g(0);
            if ('a' <= cG && cG < '{') {
                return 3;
            }
            if ('A' <= cG && cG < '[') {
                return 3;
            }
        }
        return -1;
    }

    private static final boolean p(Buffer buffer, ByteString byteString) {
        if (!Intrinsics.areEqual(byteString, f145161b) || buffer.size() < 2 || buffer.r(1L) != 58) {
            return false;
        }
        char cR = (char) buffer.r(0L);
        if ('a' > cR || cR >= '{') {
            return 'A' <= cR && cR < '[';
        }
        return true;
    }

    public static final okio.Path q(Buffer buffer, boolean z2) throws EOFException {
        ByteString byteString;
        ByteString byteStringQ1;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteStringR = null;
        int i3 = 0;
        while (true) {
            if (!buffer.E0(0L, f145160a)) {
                byteString = f145161b;
                if (!buffer.E0(0L, byteString)) {
                    break;
                }
            }
            byte b3 = buffer.readByte();
            if (byteStringR == null) {
                byteStringR = r(b3);
            }
            i3++;
        }
        boolean z3 = i3 >= 2 && Intrinsics.areEqual(byteStringR, byteString);
        if (z3) {
            Intrinsics.checkNotNull(byteStringR);
            buffer2.q2(byteStringR);
            buffer2.q2(byteStringR);
        } else if (i3 > 0) {
            Intrinsics.checkNotNull(byteStringR);
            buffer2.q2(byteStringR);
        } else {
            long jN0 = buffer.n0(f145162c);
            if (byteStringR == null) {
                byteStringR = jN0 == -1 ? s(okio.Path.f145074c) : r(buffer.r(jN0));
            }
            if (p(buffer, byteStringR)) {
                if (jN0 == 2) {
                    buffer2.H0(buffer, 3L);
                } else {
                    buffer2.H0(buffer, 2L);
                }
            }
        }
        boolean z4 = buffer2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.G1()) {
            long jN02 = buffer.n0(f145162c);
            if (jN02 == -1) {
                byteStringQ1 = buffer.M();
            } else {
                byteStringQ1 = buffer.q1(jN02);
                buffer.readByte();
            }
            ByteString byteString2 = f145164e;
            if (Intrinsics.areEqual(byteStringQ1, byteString2)) {
                if (!z4 || !arrayList.isEmpty()) {
                    if (!z2 || (!z4 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last((List) arrayList), byteString2)))) {
                        arrayList.add(byteStringQ1);
                    } else if (!z3 || arrayList.size() != 1) {
                        CollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual(byteStringQ1, f145163d) && !Intrinsics.areEqual(byteStringQ1, ByteString.f144998f)) {
                arrayList.add(byteStringQ1);
            }
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                buffer2.q2(byteStringR);
            }
            buffer2.q2((ByteString) arrayList.get(i4));
        }
        if (buffer2.size() == 0) {
            buffer2.q2(f145163d);
        }
        return new okio.Path(buffer2.M());
    }

    private static final ByteString r(byte b3) {
        if (b3 == 47) {
            return f145160a;
        }
        if (b3 == 92) {
            return f145161b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString s(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return f145160a;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return f145161b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
