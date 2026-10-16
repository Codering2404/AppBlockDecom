package androidx.compose.foundation.content.internal;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.applovin.sdk.AppLovinEventTypes;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DragAndDropRequestPermission_androidKt {
    private static final boolean a(ClipData clipData) {
        int itemCount = clipData.getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            Uri uri = clipData.getItemAt(i3).getUri();
            if (uri != null && Intrinsics.areEqual(uri.getScheme(), AppLovinEventTypes.USER_VIEWED_CONTENT)) {
                return true;
            }
        }
        return false;
    }

    public static final void b(DelegatableNode delegatableNode, DragAndDropEvent dragAndDropEvent) {
        Activity activityC;
        if (a(DragAndDrop_androidKt.b(dragAndDropEvent).getClipData()) && delegatableNode.getNode().isAttached() && (activityC = c(DelegatableNode_androidKt.a(delegatableNode))) != null) {
            DragAndDropPermissionsCompat.a(activityC, DragAndDrop_androidKt.b(dragAndDropEvent));
        }
    }

    private static final Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
