package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f145068c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteString[] f145069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f145070b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long j3, Buffer buffer, int i3, List list, int i4, int i5, List list2) {
            int i6;
            int i7;
            int i8;
            long j4;
            int i9 = i3;
            if (i4 >= i5) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i10 = i4; i10 < i5; i10++) {
                if (((ByteString) list.get(i10)).C() < i9) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = (ByteString) list.get(i4);
            ByteString byteString2 = (ByteString) list.get(i5 - 1);
            if (i9 == byteString.C()) {
                int iIntValue = ((Number) list2.get(i4)).intValue();
                int i11 = i4 + 1;
                ByteString byteString3 = (ByteString) list.get(i11);
                i6 = i11;
                i7 = iIntValue;
                byteString = byteString3;
            } else {
                i6 = i4;
                i7 = -1;
            }
            if (byteString.g(i9) == byteString2.g(i9)) {
                int iMin = Math.min(byteString.C(), byteString2.C());
                int i12 = 0;
                for (int i13 = i9; i13 < iMin && byteString.g(i13) == byteString2.g(i13); i13++) {
                    i12++;
                }
                long jC = j3 + c(buffer) + ((long) 2) + ((long) i12) + 1;
                buffer.writeInt(-i12);
                buffer.writeInt(i7);
                int i14 = i9 + i12;
                while (i9 < i14) {
                    buffer.writeInt(byteString.g(i9) & 255);
                    i9++;
                }
                if (i6 + 1 == i5) {
                    if (i14 != ((ByteString) list.get(i6)).C()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    buffer.writeInt(((Number) list2.get(i6)).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.writeInt(((int) (c(buffer2) + jC)) * (-1));
                    a(jC, buffer2, i14, list, i6, i5, list2);
                    buffer.K0(buffer2);
                    return;
                }
            }
            int i15 = 1;
            for (int i16 = i6 + 1; i16 < i5; i16++) {
                if (((ByteString) list.get(i16 - 1)).g(i9) != ((ByteString) list.get(i16)).g(i9)) {
                    i15++;
                }
            }
            long jC2 = j3 + c(buffer) + ((long) 2) + ((long) (i15 * 2));
            buffer.writeInt(i15);
            buffer.writeInt(i7);
            for (int i17 = i6; i17 < i5; i17++) {
                byte bG = ((ByteString) list.get(i17)).g(i9);
                if (i17 == i6 || bG != ((ByteString) list.get(i17 - 1)).g(i9)) {
                    buffer.writeInt(bG & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i6 < i5) {
                byte bG2 = ((ByteString) list.get(i6)).g(i9);
                int i18 = i6 + 1;
                int i19 = i18;
                while (true) {
                    if (i19 >= i5) {
                        i8 = i5;
                        break;
                    } else {
                        if (bG2 != ((ByteString) list.get(i19)).g(i9)) {
                            i8 = i19;
                            break;
                        }
                        i19++;
                    }
                }
                if (i18 == i8 && i9 + 1 == ((ByteString) list.get(i6)).C()) {
                    buffer.writeInt(((Number) list2.get(i6)).intValue());
                    j4 = jC2;
                } else {
                    buffer.writeInt(((int) (c(buffer3) + jC2)) * (-1));
                    j4 = jC2;
                    a(j4, buffer3, i9 + 1, list, i6, i8, list2);
                }
                jC2 = j4;
                i6 = i8;
            }
            buffer.K0(buffer3);
        }

        static /* synthetic */ void b(Companion companion, long j3, Buffer buffer, int i3, List list, int i4, int i5, List list2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                j3 = 0;
            }
            companion.a(j3, buffer, (i6 & 4) != 0 ? 0 : i3, list, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? list.size() : i5, list2);
        }

        private final long c(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d6, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options d(okio.ByteString... r17) {
            /*
                Method dump skipped, instruction units count: 286
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.d(okio.ByteString[]):okio.Options");
        }

        private Companion() {
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options l(ByteString... byteStringArr) {
        return f145068c.d(byteStringArr);
    }

    public /* bridge */ boolean b(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return b((ByteString) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteString get(int i3) {
        return this.f145069a[i3];
    }

    public final ByteString[] e() {
        return this.f145069a;
    }

    public final int[] f() {
        return this.f145070b;
    }

    public /* bridge */ int g(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f145069a.length;
    }

    public /* bridge */ int h(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return g((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return h((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f145069a = byteStringArr;
        this.f145070b = iArr;
    }
}
