package cz.mobilesoft.coreblock.util.helperextension;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AlertDialog;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DialogHelperExtKt$showWebsiteEditTextDialog$1$2$1 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f128528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f128529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertDialog f128530c;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        this.f128530c.j(-1).setEnabled((this.f128528a && s2.toString().length() == 0) || (s2.toString().length() > 0 && (this.f128529b || WebsiteProfileRelation.f126514h.a(s2.toString()))));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(s2, "s");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(s2, "s");
    }
}
