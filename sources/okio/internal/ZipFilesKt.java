package okio.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

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
public final class ZipFilesKt {
    private static final Map a(List list) {
        Path pathE = Path.Companion.e(Path.f145073b, "/", false, 1, null);
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a(pathE, new ZipEntry(pathE, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(((ZipEntry) obj).a(), ((ZipEntry) obj2).a());
            }
        })) {
            if (((ZipEntry) mapMutableMapOf.put(zipEntry.a(), zipEntry)) == null) {
                while (true) {
                    Path pathH = zipEntry.a().h();
                    if (pathH != null) {
                        ZipEntry zipEntry2 = (ZipEntry) mapMutableMapOf.get(pathH);
                        if (zipEntry2 != null) {
                            zipEntry2.b().add(zipEntry.a());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(pathH, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        mapMutableMapOf.put(pathH, zipEntry3);
                        zipEntry3.b().add(zipEntry.a());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mapMutableMapOf;
    }

    private static final Long b(int i3, int i4) {
        if (i4 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i3 >> 9) & 127) + 1980, ((i3 >> 5) & 15) - 1, i3 & 31, (i4 >> 11) & 31, (i4 >> 5) & 63, (i4 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String string = Integer.toString(i3, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    public static final ZipFileSystem d(Path zipPath, FileSystem fileSystem, Function1 predicate) {
        long size;
        long j3;
        BufferedSource bufferedSourceD;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle fileHandleO = fileSystem.o(zipPath);
        try {
            size = fileHandleO.size() - ((long) 22);
        } finally {
        }
        if (size < 0) {
            throw new IOException("not a zip: size=" + fileHandleO.size());
        }
        long jMax = Math.max(size - 65536, 0L);
        do {
            BufferedSource bufferedSourceD2 = Okio.d(fileHandleO.J(size));
            try {
                if (bufferedSourceD2.l2() == 101010256) {
                    EocdRecord eocdRecordF = f(bufferedSourceD2);
                    String strM1 = bufferedSourceD2.m1(eocdRecordF.b());
                    bufferedSourceD2.close();
                    long j4 = size - ((long) 20);
                    if (j4 > 0) {
                        bufferedSourceD = Okio.d(fileHandleO.J(j4));
                        try {
                            if (bufferedSourceD.l2() == 117853008) {
                                int iL2 = bufferedSourceD.l2();
                                long jB1 = bufferedSourceD.b1();
                                if (bufferedSourceD.l2() != 1 || iL2 != 0) {
                                    throw new IOException("unsupported zip: spanned");
                                }
                                bufferedSourceD = Okio.d(fileHandleO.J(jB1));
                                try {
                                    int iL22 = bufferedSourceD.l2();
                                    if (iL22 != 101075792) {
                                        throw new IOException("bad zip: expected " + c(101075792) + " but was " + c(iL22));
                                    }
                                    eocdRecordF = j(bufferedSourceD, eocdRecordF);
                                    Unit unit = Unit.f139807a;
                                    CloseableKt.a(bufferedSourceD, null);
                                } finally {
                                }
                            }
                            Unit unit2 = Unit.f139807a;
                            CloseableKt.a(bufferedSourceD, null);
                        } finally {
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    bufferedSourceD = Okio.d(fileHandleO.J(eocdRecordF.a()));
                    try {
                        long jC = eocdRecordF.c();
                        for (j3 = 0; j3 < jC; j3++) {
                            ZipEntry zipEntryE = e(bufferedSourceD);
                            if (zipEntryE.f() >= eocdRecordF.a()) {
                                throw new IOException("bad zip: local file header offset >= central directory offset");
                            }
                            if (((Boolean) predicate.invoke(zipEntryE)).booleanValue()) {
                                arrayList.add(zipEntryE);
                            }
                        }
                        Unit unit3 = Unit.f139807a;
                        CloseableKt.a(bufferedSourceD, null);
                        ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, a(arrayList), strM1);
                        CloseableKt.a(fileHandleO, null);
                        return zipFileSystem;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                bufferedSourceD2.close();
                size--;
            } finally {
                bufferedSourceD2.close();
            }
        } while (size >= jMax);
        throw new IOException("not a zip: end of central directory signature not found");
    }

    public static final ZipEntry e(final BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int iL2 = bufferedSource.l2();
        if (iL2 != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iL2));
        }
        bufferedSource.skip(4L);
        short sW0 = bufferedSource.W0();
        int i3 = sW0 & 65535;
        if ((sW0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i3));
        }
        int iW0 = bufferedSource.W0() & 65535;
        Long lB = b(bufferedSource.W0() & 65535, bufferedSource.W0() & 65535);
        long jL2 = ((long) bufferedSource.l2()) & 4294967295L;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.f140143a = ((long) bufferedSource.l2()) & 4294967295L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.f140143a = ((long) bufferedSource.l2()) & 4294967295L;
        int iW02 = bufferedSource.W0() & 65535;
        int iW03 = bufferedSource.W0() & 65535;
        int iW04 = bufferedSource.W0() & 65535;
        bufferedSource.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.f140143a = ((long) bufferedSource.l2()) & 4294967295L;
        String strM1 = bufferedSource.m1(iW02);
        if (StringsKt.Z(strM1, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j3 = longRef2.f140143a == 4294967295L ? 8 : 0L;
        if (longRef.f140143a == 4294967295L) {
            j3 += (long) 8;
        }
        if (longRef3.f140143a == 4294967295L) {
            j3 += (long) 8;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        g(bufferedSource, iW03, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(int i4, long j4) throws IOException {
                if (i4 == 1) {
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    if (booleanRef2.f140137a) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    booleanRef2.f140137a = true;
                    if (j4 < j3) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref.LongRef longRef4 = longRef2;
                    long jB1 = longRef4.f140143a;
                    if (jB1 == 4294967295L) {
                        jB1 = bufferedSource.b1();
                    }
                    longRef4.f140143a = jB1;
                    Ref.LongRef longRef5 = longRef;
                    longRef5.f140143a = longRef5.f140143a == 4294967295L ? bufferedSource.b1() : 0L;
                    Ref.LongRef longRef6 = longRef3;
                    longRef6.f140143a = longRef6.f140143a == 4294967295L ? bufferedSource.b1() : 0L;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
                c(((Number) obj).intValue(), ((Number) obj2).longValue());
                return Unit.f139807a;
            }
        });
        if (j3 <= 0 || booleanRef.f140137a) {
            return new ZipEntry(Path.Companion.e(Path.f145073b, "/", false, 1, null).j(strM1), StringsKt.E(strM1, "/", false, 2, null), bufferedSource.m1(iW04), jL2, longRef.f140143a, longRef2.f140143a, iW0, lB, longRef3.f140143a);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final EocdRecord f(BufferedSource bufferedSource) throws IOException {
        int iW0 = bufferedSource.W0() & 65535;
        int iW02 = bufferedSource.W0() & 65535;
        long jW0 = bufferedSource.W0() & 65535;
        if (jW0 != (bufferedSource.W0() & 65535) || iW0 != 0 || iW02 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(jW0, 4294967295L & ((long) bufferedSource.l2()), bufferedSource.W0() & 65535);
    }

    private static final void g(BufferedSource bufferedSource, int i3, Function2 function2) throws IOException {
        long j3 = i3;
        while (j3 != 0) {
            if (j3 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iW0 = bufferedSource.W0() & 65535;
            long jW0 = ((long) bufferedSource.W0()) & 65535;
            long j4 = j3 - ((long) 4);
            if (j4 < jW0) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.g1(jW0);
            long size = bufferedSource.u().size();
            function2.invoke(Integer.valueOf(iW0), Long.valueOf(jW0));
            long size2 = (bufferedSource.u().size() + jW0) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + iW0);
            }
            if (size2 > 0) {
                bufferedSource.u().skip(size2);
            }
            j3 = j4 - jW0;
        }
    }

    public static final FileMetadata h(BufferedSource bufferedSource, FileMetadata basicMetadata) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata fileMetadataI = i(bufferedSource, basicMetadata);
        Intrinsics.checkNotNull(fileMetadataI);
        return fileMetadataI;
    }

    private static final FileMetadata i(final BufferedSource bufferedSource, FileMetadata fileMetadata) throws IOException {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = fileMetadata != null ? fileMetadata.c() : null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int iL2 = bufferedSource.l2();
        if (iL2 != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iL2));
        }
        bufferedSource.skip(2L);
        short sW0 = bufferedSource.W0();
        int i3 = sW0 & 65535;
        if ((sW0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i3));
        }
        bufferedSource.skip(18L);
        long jW0 = ((long) bufferedSource.W0()) & 65535;
        int iW0 = bufferedSource.W0() & 65535;
        bufferedSource.skip(jW0);
        if (fileMetadata == null) {
            bufferedSource.skip(iW0);
            return null;
        }
        g(bufferedSource, iW0, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(int i4, long j3) throws IOException {
                if (i4 == 21589) {
                    if (j3 < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    byte b3 = bufferedSource.readByte();
                    boolean z2 = (b3 & 1) == 1;
                    boolean z3 = (b3 & 2) == 2;
                    boolean z4 = (b3 & 4) == 4;
                    BufferedSource bufferedSource2 = bufferedSource;
                    long j4 = z2 ? 5L : 1L;
                    if (z3) {
                        j4 += 4;
                    }
                    if (z4) {
                        j4 += 4;
                    }
                    if (j3 < j4) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z2) {
                        objectRef.f140144a = Long.valueOf(((long) bufferedSource2.l2()) * 1000);
                    }
                    if (z3) {
                        objectRef2.f140144a = Long.valueOf(((long) bufferedSource.l2()) * 1000);
                    }
                    if (z4) {
                        objectRef3.f140144a = Long.valueOf(((long) bufferedSource.l2()) * 1000);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
                c(((Number) obj).intValue(), ((Number) obj2).longValue());
                return Unit.f139807a;
            }
        });
        return new FileMetadata(fileMetadata.g(), fileMetadata.f(), null, fileMetadata.d(), (Long) objectRef3.f140144a, (Long) objectRef.f140144a, (Long) objectRef2.f140144a, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
    }

    private static final EocdRecord j(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int iL2 = bufferedSource.l2();
        int iL22 = bufferedSource.l2();
        long jB1 = bufferedSource.b1();
        if (jB1 != bufferedSource.b1() || iL2 != 0 || iL22 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(jB1, bufferedSource.b1(), eocdRecord.b());
    }

    public static final void k(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        i(bufferedSource, null);
    }
}
