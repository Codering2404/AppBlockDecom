package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.PreviewLogger;
import com.facebook.LegacyTokenHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class ComposableInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableInvoker f29668a = new ComposableInvoker();

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(Class[] clsArr, Class[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            ArrayList arrayList = new ArrayList(clsArr.length);
            int length = clsArr.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                boolean z2 = true;
                if (i3 >= length) {
                    break;
                }
                Class cls = clsArr[i3];
                int i5 = i4 + 1;
                Class cls2 = clsArr2[i4];
                if (!Intrinsics.areEqual(JvmClassMappingKt.c(cls), JvmClassMappingKt.c(cls2)) && !cls.isAssignableFrom(cls2)) {
                    z2 = false;
                }
                arrayList.add(Boolean.valueOf(z2));
                i3++;
                i4 = i5;
            }
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final int b(int i3, int i4) {
        if (i3 == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (i3 + i4)) / 10.0d);
    }

    private final int c(int i3) {
        return (int) Math.ceil(((double) i3) / 31.0d);
    }

    private final Method d(Method[] methodArr, String str, Class... clsArr) throws NoSuchMethodException {
        Method method;
        int length = methodArr.length;
        int i3 = 0;
        while (true) {
            method = null;
            if (i3 >= length) {
                break;
            }
            Method method2 = methodArr[i3];
            if (!Intrinsics.areEqual(str, method2.getName())) {
                if (!StringsKt.U(method2.getName(), str + '-', false, 2, null)) {
                    continue;
                }
                i3++;
            }
            if (f29668a.a(method2.getParameterTypes(), (Class[]) Arrays.copyOf(clsArr, clsArr.length))) {
                method = method2;
                break;
            }
            i3++;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(str + " not found");
    }

    private final Method e(Class cls, String str, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            Class<?> cls2 = obj != null ? obj.getClass() : null;
            if (cls2 != null) {
                arrayList.add(cls2);
            }
            i3++;
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        try {
            try {
                int iB = b(clsArr.length, 0);
                Class cls3 = Integer.TYPE;
                IntRange intRangeB = RangesKt.B(0, iB);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
                Iterator<Integer> it = intRangeB.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    arrayList2.add(cls3);
                }
                Class[] clsArr2 = (Class[]) arrayList2.toArray(new Class[0]);
                Method[] declaredMethods = cls.getDeclaredMethods();
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.b(clsArr);
                spreadBuilder.a(Composer.class);
                spreadBuilder.b(clsArr2);
                return d(declaredMethods, str, (Class[]) spreadBuilder.d(new Class[spreadBuilder.c()]));
            } catch (ReflectiveOperationException unused) {
                return null;
            }
        } catch (ReflectiveOperationException unused2) {
            for (Method method : cls.getDeclaredMethods()) {
                if (!Intrinsics.areEqual(method.getName(), str)) {
                    if (!StringsKt.U(method.getName(), str + '-', false, 2, null)) {
                    }
                }
                return method;
            }
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object f(Class cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals(LegacyTokenHelper.TYPE_DOUBLE)) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                return !name.equals(LegacyTokenHelper.TYPE_INTEGER) ? null : 0;
            case 3039496:
                return !name.equals(LegacyTokenHelper.TYPE_BYTE) ? null : (byte) 0;
            case 3052374:
                return !name.equals(LegacyTokenHelper.TYPE_CHAR) ? null : (char) 0;
            case 3327612:
                return !name.equals(LegacyTokenHelper.TYPE_LONG) ? null : 0L;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals(LegacyTokenHelper.TYPE_FLOAT)) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                return !name.equals(LegacyTokenHelper.TYPE_SHORT) ? null : (short) 0;
            default:
                return null;
        }
    }

    private final Object h(Method method, Object obj, Composer composer, Object... objArr) {
        Object objF;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int i3 = -1;
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                if (Intrinsics.areEqual(parameterTypes[length], Composer.class)) {
                    i3 = length;
                    break;
                }
                if (i4 < 0) {
                    break;
                }
                length = i4;
            }
        }
        int i5 = i3 + 1;
        int iB = b(i3, obj != null ? 1 : 0) + i5;
        int length2 = method.getParameterTypes().length;
        if ((length2 != iB ? c(i3) : 0) + iB != length2) {
            throw new IllegalStateException("params don't add up to total params");
        }
        Object[] objArr2 = new Object[length2];
        int i6 = 0;
        while (i6 < length2) {
            if (i6 >= 0 && i6 < i3) {
                objF = (i6 < 0 || i6 > ArraysKt.getLastIndex(objArr)) ? f29668a.f(method.getParameterTypes()[i6]) : objArr[i6];
            } else if (i6 == i3) {
                objF = composer;
            } else if (i5 <= i6 && i6 < iB) {
                objF = 0;
            } else {
                if (iB > i6 || i6 >= length2) {
                    throw new IllegalStateException("Unexpected index");
                }
                objF = 2097151;
            }
            objArr2[i6] = objF;
            i6++;
        }
        return method.invoke(obj, Arrays.copyOf(objArr2, length2));
    }

    public final void g(String str, String str2, Composer composer, Object... objArr) throws Exception {
        try {
            Class<?> cls = Class.forName(str);
            Method methodE = e(cls, str2, Arrays.copyOf(objArr, objArr.length));
            if (methodE != null) {
                methodE.setAccessible(true);
                if (Modifier.isStatic(methodE.getModifiers())) {
                    h(methodE, null, composer, Arrays.copyOf(objArr, objArr.length));
                    return;
                } else {
                    h(methodE, cls.getConstructor(null).newInstance(null), composer, Arrays.copyOf(objArr, objArr.length));
                    return;
                }
            }
            throw new NoSuchMethodException("Composable " + str + '.' + str2 + " not found");
        } catch (Exception e3) {
            PreviewLogger.Companion.c(PreviewLogger.f29762a, "Failed to invoke Composable Method '" + str + '.' + str2 + '\'', null, 2, null);
            throw e3;
        }
    }
}
