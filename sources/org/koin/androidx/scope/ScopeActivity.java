package org.koin.androidx.scope;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.scope.Scope;

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
public abstract class ScopeActivity extends AppCompatActivity implements AndroidScopeComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f145736a;

    @Override // org.koin.android.scope.AndroidScopeComponent
    public Scope getScope() {
        return (Scope) this.f145736a.getValue();
    }

    @Override // org.koin.android.scope.AndroidScopeComponent
    public void o() {
        AndroidScopeComponent.DefaultImpls.a(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getScope() == null) {
            throw new IllegalStateException("Required value was null.");
        }
    }
}
