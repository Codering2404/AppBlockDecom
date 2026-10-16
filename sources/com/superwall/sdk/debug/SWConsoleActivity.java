package com.superwall.sdk.debug;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.superwall.sdk.R;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SWConsoleActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    private static List<StoreProduct> products = CollectionsKt.emptyList();
    private ArrayAdapter<String> productAdapter;
    private Spinner productPicker;
    private RecyclerView tableView;
    private TableViewAdapter tableViewAdapter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<StoreProduct> getProducts() {
            return SWConsoleActivity.products;
        }

        public final void setProducts(List<StoreProduct> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            SWConsoleActivity.products = list;
        }

        private Companion() {
        }
    }

    private final void setupTableView() {
        RecyclerView recyclerView = this.tableView;
        TableViewAdapter tableViewAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tableView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.tableViewAdapter = new TableViewAdapter(new ArrayList(), 0);
        RecyclerView recyclerView2 = this.tableView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tableView");
            recyclerView2 = null;
        }
        TableViewAdapter tableViewAdapter2 = this.tableViewAdapter;
        if (tableViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tableViewAdapter");
        } else {
            tableViewAdapter = tableViewAdapter2;
        }
        recyclerView2.setAdapter(tableViewAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_console);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.A("Template Variables");
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.r(new ColorDrawable(-16777216));
        }
        this.productPicker = (Spinner) findViewById(R.id.productPicker);
        this.tableView = (RecyclerView) findViewById(R.id.console_recycler_view);
        int i3 = R.layout.spinner_item;
        List<StoreProduct> list = products;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((StoreProduct) it.next()).getProductIdentifier());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, i3, arrayList);
        this.productAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = this.productPicker;
        Spinner spinner2 = null;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productPicker");
            spinner = null;
        }
        ArrayAdapter<String> arrayAdapter2 = this.productAdapter;
        if (arrayAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productAdapter");
            arrayAdapter2 = null;
        }
        spinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        Spinner spinner3 = this.productPicker;
        if (spinner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productPicker");
        } else {
            spinner2 = spinner3;
        }
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.superwall.sdk.debug.SWConsoleActivity.onCreate.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i4, long j3) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(view, "view");
                TableViewAdapter tableViewAdapter = SWConsoleActivity.this.tableViewAdapter;
                if (tableViewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tableViewAdapter");
                    tableViewAdapter = null;
                }
                tableViewAdapter.updateData(SWConsoleActivity.Companion.getProducts().get(i4).getAttributes(), i4);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        setupTableView();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.menu_console, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.action_done) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
