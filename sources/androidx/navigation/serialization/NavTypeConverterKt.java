package androidx.navigation.serialization;

import androidx.navigation.NavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavTypeConverterKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49455a;

        static {
            int[] iArr = new int[InternalType.values().length];
            try {
                iArr[InternalType.f49441l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InternalType.f49442m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InternalType.f49431a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InternalType.f49433c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InternalType.f49435f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[InternalType.f49437h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[InternalType.f49439j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[InternalType.f49450u.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[InternalType.f49432b.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[InternalType.f49434d.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[InternalType.f49436g.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[InternalType.f49438i.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[InternalType.f49440k.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[InternalType.f49443n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[InternalType.f49444o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[InternalType.f49445p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[InternalType.f49446q.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[InternalType.f49447r.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[InternalType.f49448s.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[InternalType.f49449t.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[InternalType.f49451v.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            f49455a = iArr;
        }
    }

    public static final NavType a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        InternalType internalTypeC = c(serialDescriptor);
        int[] iArr = WhenMappings.f49455a;
        switch (iArr[internalTypeC.ordinal()]) {
            case 1:
                return InternalNavType.f49419a.i();
            case 2:
                return NavType.f48970q;
            case 3:
                return NavType.f48957d;
            case 4:
                return NavType.f48967n;
            case 5:
                return InternalNavType.f49419a.e();
            case 6:
                return NavType.f48964k;
            case 7:
                return NavType.f48961h;
            case 8:
                return NavTypeConverter_androidKt.b(serialDescriptor);
            case 9:
                return InternalNavType.f49419a.g();
            case 10:
                return InternalNavType.f49419a.a();
            case 11:
                return InternalNavType.f49419a.d();
            case 12:
                return InternalNavType.f49419a.f();
            case 13:
                return InternalNavType.f49419a.h();
            case 14:
                return NavType.f48959f;
            case 15:
                return NavType.f48968o;
            case 16:
                return InternalNavType.f49419a.b();
            case 17:
                return NavType.f48965l;
            case 18:
                return NavType.f48962i;
            case 19:
                int i3 = iArr[c(serialDescriptor.h(0)).ordinal()];
                return i3 != 1 ? i3 != 2 ? UNKNOWN.f49478t : InternalNavType.f49419a.j() : NavType.f48971r;
            case 20:
                switch (iArr[c(serialDescriptor.h(0)).ordinal()]) {
                    case 1:
                        return NavType.f48972s;
                    case 2:
                        return InternalNavType.f49419a.k();
                    case 3:
                        return NavType.f48960g;
                    case 4:
                        return NavType.f48969p;
                    case 5:
                        return InternalNavType.f49419a.c();
                    case 6:
                        return NavType.f48966m;
                    case 7:
                        return NavType.f48963j;
                    case 8:
                        return NavTypeConverter_androidKt.c(serialDescriptor);
                    default:
                        return UNKNOWN.f49478t;
                }
            case 21:
                return NavTypeConverter_androidKt.d(serialDescriptor);
            default:
                return UNKNOWN.f49478t;
        }
    }

    public static final boolean b(SerialDescriptor serialDescriptor, KType kType) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(kType, "kType");
        if (serialDescriptor.b() != kType.c()) {
            return false;
        }
        KSerializer kSerializerF = SerializersKt.f(kType);
        if (kSerializerF != null) {
            return Intrinsics.areEqual(serialDescriptor, kSerializerF.getDescriptor());
        }
        throw new IllegalStateException(("Cannot find KSerializer for [" + serialDescriptor.i() + "]. If applicable, custom KSerializers for custom and third-party KType is currently not supported when declared directly on a class field via @Serializable(with = ...). Please use @Serializable or @Serializable(with = ...) on the class or object declaration.").toString());
    }

    private static final InternalType c(SerialDescriptor serialDescriptor) {
        String strO = StringsKt.O(serialDescriptor.i(), "?", "", false, 4, null);
        return Intrinsics.areEqual(serialDescriptor.d(), SerialKind.ENUM.f142752a) ? serialDescriptor.b() ? InternalType.f49451v : InternalType.f49450u : Intrinsics.areEqual(strO, "kotlin.Int") ? serialDescriptor.b() ? InternalType.f49432b : InternalType.f49431a : Intrinsics.areEqual(strO, "kotlin.Boolean") ? serialDescriptor.b() ? InternalType.f49434d : InternalType.f49433c : Intrinsics.areEqual(strO, "kotlin.Double") ? serialDescriptor.b() ? InternalType.f49436g : InternalType.f49435f : Intrinsics.areEqual(strO, "kotlin.Float") ? serialDescriptor.b() ? InternalType.f49438i : InternalType.f49437h : Intrinsics.areEqual(strO, "kotlin.Long") ? serialDescriptor.b() ? InternalType.f49440k : InternalType.f49439j : Intrinsics.areEqual(strO, "kotlin.String") ? serialDescriptor.b() ? InternalType.f49442m : InternalType.f49441l : Intrinsics.areEqual(strO, "kotlin.IntArray") ? InternalType.f49443n : Intrinsics.areEqual(strO, "kotlin.DoubleArray") ? InternalType.f49445p : Intrinsics.areEqual(strO, "kotlin.BooleanArray") ? InternalType.f49444o : Intrinsics.areEqual(strO, "kotlin.FloatArray") ? InternalType.f49446q : Intrinsics.areEqual(strO, "kotlin.LongArray") ? InternalType.f49447r : Intrinsics.areEqual(strO, "kotlin.Array") ? InternalType.f49448s : StringsKt.U(strO, "kotlin.collections.ArrayList", false, 2, null) ? InternalType.f49449t : InternalType.f49452w;
    }
}
