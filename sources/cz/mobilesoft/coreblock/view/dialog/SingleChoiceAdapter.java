package cz.mobilesoft.coreblock.view.dialog;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SingleChoiceAdapter<T> extends ArrayAdapter<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f132716c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f132717d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection f132718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f132719b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleChoiceAdapter(final Context context, Object[] objects, Collection premiumIndices) {
        super(context, R.layout.Z, android.R.id.text1, objects);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objects, "objects");
        Intrinsics.checkNotNullParameter(premiumIndices, "premiumIndices");
        this.f132718a = premiumIndices;
        this.f132719b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.dialog.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SingleChoiceAdapter.d(context);
            }
        });
    }

    private final LayoutInflater b() {
        return (LayoutInflater) this.f132719b.getValue();
    }

    private final View c(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = b().inflate(R.layout.f95685a0, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        }
        try {
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            if (textView != null) {
                Object item = getItem(i3);
                if (item instanceof CharSequence) {
                    textView.setText((CharSequence) item);
                    return view;
                }
                textView.setText(String.valueOf(item));
                return view;
            }
            throw new RuntimeException("Failed to find view with ID " + getContext().getResources().getResourceName(android.R.id.text1) + " in item layout");
        } catch (ClassCastException e3) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutInflater d(Context context) {
        return LayoutInflater.from(context);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return this.f132718a.contains(Integer.valueOf(i3)) ? 1 : 0;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (getItemViewType(i3) == 1) {
            return c(i3, view, parent);
        }
        View view2 = super.getView(i3, view, parent);
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
