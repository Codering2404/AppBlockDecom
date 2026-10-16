package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleCompat;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class SavedStateReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f52998a;

    public static final Parcelable[] A(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        Parcelable[] parcelableArrB = BundleCompat.b(bundle, key, JvmClassMappingKt.a(parcelableClass));
        if (parcelableArrB != null) {
            return parcelableArrB;
        }
        return null;
    }

    public static final List B(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        ArrayList arrayListC = BundleCompat.c(bundle, key, JvmClassMappingKt.a(parcelableClass));
        if (arrayListC != null) {
            return arrayListC;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final Bundle C(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle2 = bundle.getBundle(key);
        if (bundle2 != null) {
            return bundle2;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final List D(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return B(bundle, key, Reflection.b(Bundle.class));
    }

    public static final Bundle E(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return bundle.getBundle(key);
    }

    public static final Size F(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Size size = bundle.getSize(key);
        if (size != null) {
            return size;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final SizeF G(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SizeF sizeF = bundle.getSizeF(key);
        if (sizeF != null) {
            return sizeF;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final SparseArray H(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        SparseArray sparseArrayI = I(bundle, key, parcelableClass);
        if (sparseArrayI != null) {
            return sparseArrayI;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final SparseArray I(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        return BundleCompat.e(bundle, key, JvmClassMappingKt.a(parcelableClass));
    }

    public static final String J(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = bundle.getString(key);
        if (string != null) {
            return string;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final String[] K(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String[] stringArray = bundle.getStringArray(key);
        if (stringArray != null) {
            return stringArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final List L(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(key);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final List M(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return bundle.getStringArrayList(key);
    }

    public static int N(Bundle bundle) {
        return bundle.hashCode();
    }

    public static final boolean O(Bundle bundle) {
        return bundle.isEmpty();
    }

    public static final boolean P(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return b(bundle, key) && bundle.get(key) == null;
    }

    public static final int Q(Bundle bundle) {
        return bundle.size();
    }

    public static final Map R(Bundle bundle) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder(bundle.size());
        for (String str : bundle.keySet()) {
            Intrinsics.checkNotNull(str);
            mapCreateMapBuilder.put(str, bundle.get(str));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static String S(Bundle bundle) {
        return "SavedStateReader(source=" + bundle + ')';
    }

    public static Bundle a(Bundle source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return source;
    }

    public static final boolean b(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return bundle.containsKey(key);
    }

    public static final boolean c(Bundle bundle, Bundle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.c(bundle, other);
    }

    public static final int d(Bundle bundle) {
        return SavedStateReaderKt__SavedStateReader_androidKt.d(bundle);
    }

    public static boolean e(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateReader) && Intrinsics.areEqual(bundle, ((SavedStateReader) obj).T());
    }

    public static final IBinder f(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        IBinder binder = bundle.getBinder(key);
        if (binder != null) {
            return binder;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final boolean g(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z2 = bundle.getBoolean(key, false);
        if (z2 || !bundle.getBoolean(key, true)) {
            return z2;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final boolean[] h(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean[] booleanArray = bundle.getBooleanArray(key);
        if (booleanArray != null) {
            return booleanArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final Boolean i(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z2 = bundle.getBoolean(key, false);
        if (z2 || !bundle.getBoolean(key, true)) {
            return Boolean.valueOf(z2);
        }
        return null;
    }

    public static final char j(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        char c3 = bundle.getChar(key, (char) 0);
        if (c3 != 0 || bundle.getChar(key, (char) 65535) != 65535) {
            return c3;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final char[] k(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        char[] charArray = bundle.getCharArray(key);
        if (charArray != null) {
            return charArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final CharSequence l(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CharSequence charSequence = bundle.getCharSequence(key);
        if (charSequence != null) {
            return charSequence;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final CharSequence[] m(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(key);
        if (charSequenceArray != null) {
            return charSequenceArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final List n(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(key);
        if (charSequenceArrayList != null) {
            return charSequenceArrayList;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final double o(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        double d3 = bundle.getDouble(key, Double.MIN_VALUE);
        if (d3 != Double.MIN_VALUE || bundle.getDouble(key, Double.MAX_VALUE) != Double.MAX_VALUE) {
            return d3;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final double[] p(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        double[] doubleArray = bundle.getDoubleArray(key);
        if (doubleArray != null) {
            return doubleArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final float q(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        float f3 = bundle.getFloat(key, Float.MIN_VALUE);
        if (f3 != Float.MIN_VALUE || bundle.getFloat(key, Float.MAX_VALUE) != Float.MAX_VALUE) {
            return f3;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final float[] r(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        float[] floatArray = bundle.getFloatArray(key);
        if (floatArray != null) {
            return floatArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final int s(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i3 = bundle.getInt(key, Integer.MIN_VALUE);
        if (i3 != Integer.MIN_VALUE || bundle.getInt(key, Api.BaseClientBuilder.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i3;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final int[] t(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int[] intArray = bundle.getIntArray(key);
        if (intArray != null) {
            return intArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final List u(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(key);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final Serializable v(Bundle bundle, String key, KClass serializableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        Serializable serializableD = BundleCompat.d(bundle, key, JvmClassMappingKt.a(serializableClass));
        if (serializableD != null) {
            return serializableD;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final long w(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long j3 = bundle.getLong(key, Long.MIN_VALUE);
        if (j3 != Long.MIN_VALUE || bundle.getLong(key, Long.MAX_VALUE) != Long.MAX_VALUE) {
            return j3;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final long[] x(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long[] longArray = bundle.getLongArray(key);
        if (longArray != null) {
            return longArray;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final Parcelable y(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        Parcelable parcelable = (Parcelable) BundleCompat.a(bundle, key, JvmClassMappingKt.a(parcelableClass));
        if (parcelable != null) {
            return parcelable;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public static final Parcelable[] z(Bundle bundle, String key, KClass parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        Parcelable[] parcelableArrA = A(bundle, key, parcelableClass);
        if (parcelableArrA != null) {
            return parcelableArrA;
        }
        SavedStateReaderKt.a(key);
        throw new KotlinNothingValueException();
    }

    public final /* synthetic */ Bundle T() {
        return this.f52998a;
    }

    public boolean equals(Object obj) {
        return e(this.f52998a, obj);
    }

    public int hashCode() {
        return N(this.f52998a);
    }

    public String toString() {
        return S(this.f52998a);
    }
}
