package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
public final class SavedStateWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f53004a;

    public static final void A(Bundle bundle, String key, Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBundle(key, value);
    }

    public static final void B(Bundle bundle, String key, List value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        z(bundle, key, value);
    }

    public static final void C(Bundle bundle, String key, Size value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSize(key, value);
    }

    public static final void D(Bundle bundle, String key, SizeF value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSizeF(key, value);
    }

    public static final void E(Bundle bundle, String key, SparseArray value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSparseParcelableArray(key, value);
    }

    public static final void F(Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putString(key, value);
    }

    public static final void G(Bundle bundle, String key, String[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putStringArray(key, value);
    }

    public static final void H(Bundle bundle, String key, List value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putStringArrayList(key, SavedStateWriterKt.a(value));
    }

    public static final void I(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.remove(key);
    }

    public static String J(Bundle bundle) {
        return "SavedStateWriter(source=" + bundle + ')';
    }

    public static Bundle a(Bundle source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return source;
    }

    public static boolean b(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateWriter) && Intrinsics.areEqual(bundle, ((SavedStateWriter) obj).K());
    }

    public static int c(Bundle bundle) {
        return bundle.hashCode();
    }

    public static final void e(Bundle bundle, String key, IBinder value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBinder(key, value);
    }

    public static final void f(Bundle bundle, String key, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putBoolean(key, z2);
    }

    public static final void g(Bundle bundle, String key, boolean[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBooleanArray(key, value);
    }

    public static final void h(Bundle bundle, String key, char c3) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putChar(key, c3);
    }

    public static final void i(Bundle bundle, String key, char[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharArray(key, value);
    }

    public static final void j(Bundle bundle, String key, CharSequence value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequence(key, value);
    }

    public static final void k(Bundle bundle, String key, CharSequence[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequenceArray(key, value);
    }

    public static final void l(Bundle bundle, String key, List value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequenceArrayList(key, SavedStateWriterKt.a(value));
    }

    public static final void m(Bundle bundle, String key, double d3) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putDouble(key, d3);
    }

    public static final void n(Bundle bundle, String key, double[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putDoubleArray(key, value);
    }

    public static final void o(Bundle bundle, String key, float f3) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putFloat(key, f3);
    }

    public static final void p(Bundle bundle, String key, float[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putFloatArray(key, value);
    }

    public static final void q(Bundle bundle, String key, int i3) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putInt(key, i3);
    }

    public static final void r(Bundle bundle, String key, int[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putIntArray(key, value);
    }

    public static final void s(Bundle bundle, String key, List value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putIntegerArrayList(key, SavedStateWriterKt.a(value));
    }

    public static final void t(Bundle bundle, String key, Serializable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSerializable(key, value);
    }

    public static final void u(Bundle bundle, String key, long j3) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putLong(key, j3);
    }

    public static final void v(Bundle bundle, String key, long[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putLongArray(key, value);
    }

    public static final void w(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putString(key, null);
    }

    public static final void x(Bundle bundle, String key, Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelable(key, value);
    }

    public static final void y(Bundle bundle, String key, Parcelable[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelableArray(key, value);
    }

    public static final void z(Bundle bundle, String key, List value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelableArrayList(key, SavedStateWriterKt.a(value));
    }

    public final /* synthetic */ Bundle K() {
        return this.f53004a;
    }

    public boolean equals(Object obj) {
        return b(this.f53004a, obj);
    }

    public int hashCode() {
        return c(this.f53004a);
    }

    public String toString() {
        return J(this.f53004a);
    }

    public static final void d(Bundle bundle, Bundle bundle2) {
        Intrinsics.checkNotNullParameter(bundle2, rnFwbPAQmQTnL.NXCGHjZEltznNbE);
        bundle.putAll(bundle2);
    }
}
