package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Path implements Comparable<Path> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f145073b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f145074c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteString f145075a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path d(Companion companion, File file, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = false;
            }
            return companion.a(file, z2);
        }

        public static /* synthetic */ Path e(Companion companion, String str, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = false;
            }
            return companion.b(str, z2);
        }

        public static /* synthetic */ Path f(Companion companion, java.nio.file.Path path, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = false;
            }
            return companion.c(path, z2);
        }

        public final Path a(File file, boolean z2) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String string = file.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString()");
            return b(string, z2);
        }

        public final Path b(String str, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return okio.internal.Path.k(str, z2);
        }

        public final Path c(java.nio.file.Path path, boolean z2) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return b(path.toString(), z2);
        }

        private Companion() {
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        f145074c = separator;
    }

    public Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f145075a = bytes;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return b().compareTo(other.b());
    }

    public final ByteString b() {
        return this.f145075a;
    }

    public final Path c() {
        int iO = okio.internal.Path.o(this);
        if (iO == -1) {
            return null;
        }
        return new Path(b().E(0, iO));
    }

    public final List d() {
        ArrayList arrayList = new ArrayList();
        int iO = okio.internal.Path.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < b().C() && b().g(iO) == 92) {
            iO++;
        }
        int iC = b().C();
        int i3 = iO;
        while (iO < iC) {
            if (b().g(iO) == 47 || b().g(iO) == 92) {
                arrayList.add(b().E(i3, iO));
                i3 = iO + 1;
            }
            iO++;
        }
        if (i3 < b().C()) {
            arrayList.add(b().E(i3, b().C()));
        }
        return arrayList;
    }

    public final String e() {
        return f().I();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).b(), b());
    }

    public final ByteString f() {
        int iL = okio.internal.Path.l(this);
        return iL != -1 ? ByteString.F(b(), iL + 1, 0, 2, null) : (n() == null || b().C() != 2) ? b() : ByteString.f144998f;
    }

    public final Path g() {
        return f145073b.b(toString(), true);
    }

    public final Path h() {
        if (Intrinsics.areEqual(b(), okio.internal.Path.f145163d) || Intrinsics.areEqual(b(), okio.internal.Path.f145160a) || Intrinsics.areEqual(b(), okio.internal.Path.f145161b) || okio.internal.Path.n(this)) {
            return null;
        }
        int iL = okio.internal.Path.l(this);
        if (iL == 2 && n() != null) {
            if (b().C() == 3) {
                return null;
            }
            return new Path(ByteString.F(b(), 0, 3, 1, null));
        }
        if (iL == 1 && b().D(okio.internal.Path.f145161b)) {
            return null;
        }
        if (iL != -1 || n() == null) {
            return iL == -1 ? new Path(okio.internal.Path.f145163d) : iL == 0 ? new Path(ByteString.F(b(), 0, 1, 1, null)) : new Path(ByteString.F(b(), 0, iL, 1, null));
        }
        if (b().C() == 2) {
            return null;
        }
        return new Path(ByteString.F(b(), 0, 2, 1, null));
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final Path i(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(c(), other.c())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List listD = d();
        List listD2 = other.d();
        int iMin = Math.min(listD.size(), listD2.size());
        int i3 = 0;
        while (i3 < iMin && Intrinsics.areEqual(listD.get(i3), listD2.get(i3))) {
            i3++;
        }
        if (i3 == iMin && b().C() == other.b().C()) {
            return Companion.e(f145073b, ".", false, 1, null);
        }
        if (listD2.subList(i3, listD2.size()).indexOf(okio.internal.Path.f145164e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        Buffer buffer = new Buffer();
        ByteString byteStringM = okio.internal.Path.m(other);
        if (byteStringM == null && (byteStringM = okio.internal.Path.m(this)) == null) {
            byteStringM = okio.internal.Path.s(f145074c);
        }
        int size = listD2.size();
        for (int i4 = i3; i4 < size; i4++) {
            buffer.q2(okio.internal.Path.f145164e);
            buffer.q2(byteStringM);
        }
        int size2 = listD.size();
        while (i3 < size2) {
            buffer.q2((ByteString) listD.get(i3));
            buffer.q2(byteStringM);
            i3++;
        }
        return okio.internal.Path.q(buffer, false);
    }

    public final boolean isAbsolute() {
        return okio.internal.Path.o(this) != -1;
    }

    public final Path j(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.j(this, okio.internal.Path.q(new Buffer().C0(child), false), false);
    }

    public final Path k(Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.j(this, child, false);
    }

    public final Path l(Path child, boolean z2) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.j(this, child, z2);
    }

    public final java.nio.file.Path m() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    public final Character n() {
        if (ByteString.o(b(), okio.internal.Path.f145160a, 0, 2, null) != -1 || b().C() < 2 || b().g(1) != 58) {
            return null;
        }
        char cG = (char) b().g(0);
        if (('a' > cG || cG >= '{') && ('A' > cG || cG >= '[')) {
            return null;
        }
        return Character.valueOf(cG);
    }

    public final File toFile() {
        return new File(toString());
    }

    public String toString() {
        return b().I();
    }
}
