package com.superwall.sdk.analytics;

import android.content.Context;
import com.superwall.sdk.analytics.CPUInfo;
import com.superwall.sdk.analytics.ClassifierDataFactory;
import com.superwall.sdk.analytics.DeviceClassifier;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DefaultClassifierDataFactory implements ClassifierDataFactory {
    private final Function0<Context> _context;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultClassifierDataFactory(Function0<? extends Context> _context) {
        Intrinsics.checkNotNullParameter(_context, "_context");
        this._context = _context;
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public long advertisedMemory() {
        return ClassifierDataFactory.DefaultImpls.advertisedMemory(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public List<String> codecs() {
        return ClassifierDataFactory.DefaultImpls.codecs(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public Context context() {
        return (Context) this._context.invoke();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public CPUInfo.Data getCpuInfo() {
        return ClassifierDataFactory.DefaultImpls.getCpuInfo(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public DeviceClassifier.Orientation getOrientation() {
        return ClassifierDataFactory.DefaultImpls.getOrientation(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenHeight() {
        return ClassifierDataFactory.DefaultImpls.getScreenHeight(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public double getScreenSize() {
        return ClassifierDataFactory.DefaultImpls.getScreenSize(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenWidth() {
        return ClassifierDataFactory.DefaultImpls.getScreenWidth(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public boolean isTabletMinWidth() {
        return ClassifierDataFactory.DefaultImpls.isTabletMinWidth(this);
    }
}
