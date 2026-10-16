package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SavedStateHandle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f40079c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f40080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SavedStateHandleImpl f40081b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SavedStateHandle a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new SavedStateHandle();
            }
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            bundle.setClassLoader(classLoader);
            return new SavedStateHandle(SavedStateReader.R(SavedStateReader.a(bundle)));
        }

        public final boolean b(Object obj) {
            return SavedStateHandleImpl_androidKt.a(obj);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f40082l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private SavedStateHandle f40083m;

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void p(Object obj) {
            SavedStateHandleImpl savedStateHandleImpl;
            SavedStateHandle savedStateHandle = this.f40083m;
            if (savedStateHandle != null && (savedStateHandleImpl = savedStateHandle.f40081b) != null) {
                savedStateHandleImpl.g(this.f40082l, obj);
            }
            super.p(obj);
        }
    }

    public SavedStateHandle(Map initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.f40080a = new LinkedHashMap();
        this.f40081b = new SavedStateHandleImpl(initialState);
    }

    public final boolean b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f40081b.b(key);
    }

    public final Object c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f40081b.c(key);
    }

    public final SavedStateRegistry.SavedStateProvider d() {
        return this.f40081b.d();
    }

    public final void e(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (f40079c.b(obj)) {
            Object obj2 = this.f40080a.get(key);
            MutableLiveData mutableLiveData = obj2 instanceof MutableLiveData ? (MutableLiveData) obj2 : null;
            if (mutableLiveData != null) {
                mutableLiveData.p(obj);
            }
            this.f40081b.g(key, obj);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        Intrinsics.checkNotNull(obj);
        sb.append(obj.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final void f(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f40081b.h(key, provider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateHandle() {
        this.f40080a = new LinkedHashMap();
        this.f40081b = new SavedStateHandleImpl(null, 1, 0 == true ? 1 : 0);
    }
}
