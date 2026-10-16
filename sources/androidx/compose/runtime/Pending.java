package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MultiValueMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class Pending {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f23997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f24000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableIntObjectMap f24001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f24002f;

    public Pending(List list, int i3) {
        this.f23997a = list;
        this.f23998b = i3;
        if (!(i3 >= 0)) {
            PreconditionsKt.a("Invalid start index");
        }
        this.f24000d = new ArrayList();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        int size = list.size();
        int iC = 0;
        for (int i4 = 0; i4 < size; i4++) {
            KeyInfo keyInfo = (KeyInfo) this.f23997a.get(i4);
            mutableIntObjectMap.r(keyInfo.b(), new GroupInfo(i4, iC, keyInfo.c()));
            iC += keyInfo.c();
        }
        this.f24001e = mutableIntObjectMap;
        this.f24002f = LazyKt.b(new Function0<MultiValueMap<Object, KeyInfo>>() { // from class: androidx.compose.runtime.Pending$keyMap$2
            {
                super(0);
            }

            public final MutableScatterMap c() {
                MutableScatterMap mutableScatterMapN = ComposerKt.N(this.f24003a.b().size());
                Pending pending = this.f24003a;
                int size2 = pending.b().size();
                for (int i5 = 0; i5 < size2; i5++) {
                    KeyInfo keyInfo2 = (KeyInfo) pending.b().get(i5);
                    MultiValueMap.a(mutableScatterMapN, ComposerKt.E(keyInfo2), keyInfo2);
                }
                return mutableScatterMapN;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return MultiValueMap.b(c());
            }
        });
    }

    public final int a() {
        return this.f23999c;
    }

    public final List b() {
        return this.f23997a;
    }

    public final MutableScatterMap c() {
        return ((MultiValueMap) this.f24002f.getValue()).p();
    }

    public final KeyInfo d(int i3, Object obj) {
        return (KeyInfo) MultiValueMap.l(c(), obj != null ? new JoinedKey(Integer.valueOf(i3), obj) : Integer.valueOf(i3));
    }

    public final int e() {
        return this.f23998b;
    }

    public final List f() {
        return this.f24000d;
    }

    public final int g(KeyInfo keyInfo) {
        GroupInfo groupInfo = (GroupInfo) this.f24001e.b(keyInfo.b());
        if (groupInfo != null) {
            return groupInfo.b();
        }
        return -1;
    }

    public final boolean h(KeyInfo keyInfo) {
        return this.f24000d.add(keyInfo);
    }

    public final void i(KeyInfo keyInfo, int i3) {
        this.f24001e.r(keyInfo.b(), new GroupInfo(-1, i3, 0));
    }

    public final void j(int i3, int i4, int i5) {
        char c3;
        long j3;
        char c4;
        long j4;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        if (i3 > i4) {
            MutableIntObjectMap mutableIntObjectMap = this.f24001e;
            Object[] objArr = mutableIntObjectMap.f2887c;
            long[] jArr = mutableIntObjectMap.f2885a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << c5) & j6 & j5) != j5) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j6 & 255) < 128) {
                            c4 = c5;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i6 << 3) + i8];
                            j4 = j5;
                            int iB = groupInfo.b();
                            if (i3 <= iB && iB < i3 + i5) {
                                groupInfo.e((iB - i3) + i4);
                            } else if (i4 <= iB && iB < i3) {
                                groupInfo.e(iB + i5);
                            }
                        } else {
                            c4 = c5;
                            j4 = j5;
                        }
                        j6 >>= 8;
                        i8++;
                        c5 = c4;
                        j5 = j4;
                    }
                    c3 = c5;
                    j3 = j5;
                    if (i7 != 8) {
                        return;
                    }
                } else {
                    c3 = c5;
                    j3 = j5;
                }
                if (i6 == length) {
                    return;
                }
                i6++;
                c5 = c3;
                j5 = j3;
            }
        } else {
            if (i4 <= i3) {
                return;
            }
            MutableIntObjectMap mutableIntObjectMap2 = this.f24001e;
            Object[] objArr2 = mutableIntObjectMap2.f2887c;
            long[] jArr2 = mutableIntObjectMap2.f2885a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i9 = 0;
            while (true) {
                long j7 = jArr2[i9];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i9 - length2)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((j7 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i9 << 3) + i11];
                            int iB2 = groupInfo2.b();
                            if (i3 <= iB2 && iB2 < i3 + i5) {
                                groupInfo2.e((iB2 - i3) + i4);
                            } else if (i3 + 1 <= iB2 && iB2 < i4) {
                                groupInfo2.e(iB2 - i5);
                            }
                        }
                        j7 >>= 8;
                    }
                    if (i10 != 8) {
                        return;
                    }
                }
                if (i9 == length2) {
                    return;
                } else {
                    i9++;
                }
            }
        }
    }

    public final void k(int i3, int i4) {
        char c3;
        long j3;
        char c4;
        long j4;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        if (i3 > i4) {
            MutableIntObjectMap mutableIntObjectMap = this.f24001e;
            Object[] objArr = mutableIntObjectMap.f2887c;
            long[] jArr = mutableIntObjectMap.f2885a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << c5) & j6 & j5) != j5) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j6 & 255) < 128) {
                            c4 = c5;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i5 << 3) + i7];
                            j4 = j5;
                            int iC = groupInfo.c();
                            if (iC == i3) {
                                groupInfo.f(i4);
                            } else if (i4 <= iC && iC < i3) {
                                groupInfo.f(iC + 1);
                            }
                        } else {
                            c4 = c5;
                            j4 = j5;
                        }
                        j6 >>= 8;
                        i7++;
                        c5 = c4;
                        j5 = j4;
                    }
                    c3 = c5;
                    j3 = j5;
                    if (i6 != 8) {
                        return;
                    }
                } else {
                    c3 = c5;
                    j3 = j5;
                }
                if (i5 == length) {
                    return;
                }
                i5++;
                c5 = c3;
                j5 = j3;
            }
        } else {
            if (i4 <= i3) {
                return;
            }
            MutableIntObjectMap mutableIntObjectMap2 = this.f24001e;
            Object[] objArr2 = mutableIntObjectMap2.f2887c;
            long[] jArr2 = mutableIntObjectMap2.f2885a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i8 = 0;
            while (true) {
                long j7 = jArr2[i8];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i8 - length2)) >>> 31);
                    for (int i10 = 0; i10 < i9; i10++) {
                        if ((j7 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i8 << 3) + i10];
                            int iC2 = groupInfo2.c();
                            if (iC2 == i3) {
                                groupInfo2.f(i4);
                            } else if (i3 + 1 <= iC2 && iC2 < i4) {
                                groupInfo2.f(iC2 - 1);
                            }
                        }
                        j7 >>= 8;
                    }
                    if (i9 != 8) {
                        return;
                    }
                }
                if (i8 == length2) {
                    return;
                } else {
                    i8++;
                }
            }
        }
    }

    public final void l(int i3) {
        this.f23999c = i3;
    }

    public final int m(KeyInfo keyInfo) {
        GroupInfo groupInfo = (GroupInfo) this.f24001e.b(keyInfo.b());
        if (groupInfo != null) {
            return groupInfo.c();
        }
        return -1;
    }

    public final boolean n(int i3, int i4) {
        int iB;
        GroupInfo groupInfo = (GroupInfo) this.f24001e.b(i3);
        if (groupInfo == null) {
            return false;
        }
        int iB2 = groupInfo.b();
        int iA = i4 - groupInfo.a();
        groupInfo.d(i4);
        if (iA == 0) {
            return true;
        }
        MutableIntObjectMap mutableIntObjectMap = this.f24001e;
        Object[] objArr = mutableIntObjectMap.f2887c;
        long[] jArr = mutableIntObjectMap.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j3 = jArr[i5];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j3) < 128) {
                        GroupInfo groupInfo2 = (GroupInfo) objArr[(i5 << 3) + i7];
                        if (groupInfo2.b() >= iB2 && !Intrinsics.areEqual(groupInfo2, groupInfo) && (iB = groupInfo2.b() + iA) >= 0) {
                            groupInfo2.e(iB);
                        }
                    }
                    j3 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i5 == length) {
                return true;
            }
            i5++;
        }
    }

    public final int o(KeyInfo keyInfo) {
        GroupInfo groupInfo = (GroupInfo) this.f24001e.b(keyInfo.b());
        return groupInfo != null ? groupInfo.a() : keyInfo.c();
    }
}
