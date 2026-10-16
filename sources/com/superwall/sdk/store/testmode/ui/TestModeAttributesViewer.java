package com.superwall.sdk.store.testmode.ui;

import android.R;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
public final class TestModeAttributesViewer {
    public static final TestModeAttributesViewer INSTANCE = new TestModeAttributesViewer();

    private TestModeAttributesViewer() {
    }

    private final List<Pair<String, String>> parseAttributes(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                arrayList.add(TuplesKt.a(next, jSONObject.get(next).toString()));
            }
        } catch (Exception unused) {
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.superwall.sdk.store.testmode.ui.TestModeAttributesViewer$parseAttributes$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d((String) ((Pair) t2).e(), (String) ((Pair) t3).e());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(Context context, String str, String str2, View view) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(str, str2));
        Toast.makeText(context, str + " copied", 0).show();
    }

    public final void show(final Context context, String title, String attributesJson) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(attributesJson, "attributesJson");
        final Dialog dialog = new Dialog(context, R.style.Theme.DeviceDefault.Light.NoActionBar);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        View viewInflate = layoutInflaterFrom.inflate(com.superwall.sdk.R.layout.test_mode_attributes_viewer, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(com.superwall.sdk.R.id.viewer_title)).setText(title);
        viewInflate.findViewById(com.superwall.sdk.R.id.back_button).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        ViewGroup viewGroup = (LinearLayout) viewInflate.findViewById(com.superwall.sdk.R.id.attributes_container);
        List<Pair<String, String>> attributes = parseAttributes(attributesJson);
        for (Pair<String, String> pair : attributes) {
            final String str = (String) pair.a();
            final String str2 = (String) pair.b();
            View viewInflate2 = layoutInflaterFrom.inflate(com.superwall.sdk.R.layout.test_mode_attribute_row, viewGroup, false);
            ((TextView) viewInflate2.findViewById(com.superwall.sdk.R.id.attribute_key)).setText(str);
            ((TextView) viewInflate2.findViewById(com.superwall.sdk.R.id.attribute_value)).setText(str2);
            viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeAttributesViewer.show$lambda$1(context, str, str2, view);
                }
            });
            viewGroup.addView(viewInflate2);
        }
        if (attributes.isEmpty()) {
            TextView textView = new TextView(context);
            textView.setText("No attributes available.");
            textView.setTextSize(14.0f);
            textView.setTextColor(-6710887);
            viewGroup.addView(textView);
        }
        dialog.setContentView(viewInflate);
        dialog.show();
    }
}
