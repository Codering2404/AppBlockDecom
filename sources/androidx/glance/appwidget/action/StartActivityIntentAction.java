package androidx.glance.appwidget.action;

import android.content.Intent;
import android.os.Bundle;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.StartActivityAction;
import kotlin.Metadata;

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
public final class StartActivityIntentAction implements StartActivityAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Intent f38563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActionParameters f38564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f38565c;

    public StartActivityIntentAction(Intent intent, ActionParameters actionParameters, Bundle bundle) {
        this.f38563a = intent;
        this.f38564b = actionParameters;
        this.f38565c = bundle;
    }

    @Override // androidx.glance.action.StartActivityAction
    public Bundle a() {
        return this.f38565c;
    }

    public final Intent c() {
        return this.f38563a;
    }

    @Override // androidx.glance.action.StartActivityAction
    public ActionParameters getParameters() {
        return this.f38564b;
    }
}
