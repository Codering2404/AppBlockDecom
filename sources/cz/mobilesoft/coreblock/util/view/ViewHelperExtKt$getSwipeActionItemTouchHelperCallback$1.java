package cz.mobilesoft.coreblock.util.view;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
public final class ViewHelperExtKt$getSwipeActionItemTouchHelperCallback$1 extends ItemTouchHelper.SimpleCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f129947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function2 f129948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ColorDrawable f129949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f129950i;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void B(RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.f129947f.invoke(Integer.valueOf(viewHolder.getBindingAdapterPosition()), viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void u(Canvas c3, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f3, float f4, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(c3, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Drawable drawable = (Drawable) this.f129948g.invoke(Integer.valueOf(viewHolder.getBindingAdapterPosition()), viewHolder);
        View itemView = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        int height = (viewHolder.itemView.getHeight() - drawable.getIntrinsicHeight()) / 2;
        if (f3 > 0.0f) {
            this.f129949h.setBounds(itemView.getLeft(), itemView.getTop(), (int) f3, itemView.getBottom());
            drawable.setBounds(itemView.getLeft() + this.f129950i, itemView.getTop() + height, itemView.getLeft() + this.f129950i + drawable.getIntrinsicWidth(), itemView.getBottom() - height);
        } else {
            this.f129949h.setBounds(itemView.getRight() + ((int) f3), itemView.getTop(), itemView.getRight(), itemView.getBottom());
            drawable.setBounds((itemView.getRight() - this.f129950i) - drawable.getIntrinsicWidth(), itemView.getTop() + height, itemView.getRight() - this.f129950i, itemView.getBottom() - height);
            drawable.setLevel(0);
        }
        this.f129949h.draw(c3);
        c3.save();
        if (f3 > 0.0f) {
            c3.clipRect(itemView.getLeft(), itemView.getTop(), (int) f3, itemView.getBottom());
        } else {
            c3.clipRect(itemView.getRight() + ((int) f3), itemView.getTop(), itemView.getRight(), itemView.getBottom());
        }
        drawable.draw(c3);
        c3.restore();
        super.u(c3, recyclerView, viewHolder, f3, f4, i3, z2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean y(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "viewHolder2");
        return false;
    }
}
