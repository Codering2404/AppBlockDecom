package cz.mobilesoft.coreblock.view.stack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.stack.PermissionCardView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class PermissionCardView extends BaseStackCardView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f132952v = BaseStackCardView.f132950u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, PermissionDTO permissionDTO, View view) {
        function1.invoke(permissionDTO);
    }

    public final void t(final PermissionDTO permissionDTO, int i3, final Function1 onPermissionClicked) {
        Intrinsics.checkNotNullParameter(permissionDTO, "permissionDTO");
        Intrinsics.checkNotNullParameter(onPermissionClicked, "onPermissionClicked");
        String string = getContext().getString(Permission.j(permissionDTO.e(), false, 1, null));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BaseStackCardView.r(this, string, permissionDTO.d(context), i3, null, permissionDTO.c(), 8, null);
        setOnClickListener(new View.OnClickListener() { // from class: l2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionCardView.u(onPermissionClicked, permissionDTO, view);
            }
        });
    }
}
