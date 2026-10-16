package com.superwall.sdk.debug.localizations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.superwall.sdk.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class SWLocalizationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    public static final Companion Companion = new Companion(null);
    private static Function1<? super String, Unit> completion;
    private LocalizationAdapter adapter;
    private LocalizationManager localizationManager;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private final Lazy allRowModels$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.localizations.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SWLocalizationActivity.allRowModels_delegate$lambda$0(this.f93522a);
        }
    });
    private List<LocalizationGrouping> rowModels = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1<String, Unit> getCompletion() {
            return SWLocalizationActivity.completion;
        }

        public final void setCompletion(Function1<? super String, Unit> function1) {
            SWLocalizationActivity.completion = function1;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allRowModels_delegate$lambda$0(SWLocalizationActivity sWLocalizationActivity) {
        LocalizationManager localizationManager = sWLocalizationActivity.localizationManager;
        if (localizationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localizationManager");
            localizationManager = null;
        }
        return localizationManager.getLocalizationGroupings();
    }

    private final void completion(String str) {
        Intent intent = new Intent();
        intent.putExtra("locale", str);
        setResult(-1, intent);
        finish();
    }

    private final List<LocalizationGrouping> getAllRowModels() {
        return (List) this.allRowModels$delegate.getValue();
    }

    private final void setupActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.A("Localization");
        }
    }

    private final void setupRecyclerView() {
        this.adapter = new LocalizationAdapter(this.rowModels, new Function1() { // from class: com.superwall.sdk.debug.localizations.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SWLocalizationActivity.setupRecyclerView$lambda$1(this.f93521a, (String) obj);
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        LocalizationAdapter localizationAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        LocalizationAdapter localizationAdapter2 = this.adapter;
        if (localizationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            localizationAdapter = localizationAdapter2;
        }
        recyclerView2.setAdapter(localizationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$1(SWLocalizationActivity sWLocalizationActivity, String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        sWLocalizationActivity.finish();
        Function1<? super String, Unit> function1 = completion;
        if (function1 != null) {
            function1.invoke(locale);
        }
        return Unit.f139807a;
    }

    private final void setupSearchView() {
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        this.searchView = searchView;
        if (searchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
            searchView = null;
        }
        searchView.setOnQueryTextListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_localization);
        this.localizationManager = new LocalizationManager();
        this.rowModels = getAllRowModels();
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setupRecyclerView();
        setupSearchView();
        setupActionBar();
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        if (str == null) {
            return true;
        }
        LocalizationManager localizationManager = this.localizationManager;
        LocalizationAdapter localizationAdapter = null;
        if (localizationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localizationManager");
            localizationManager = null;
        }
        this.rowModels = localizationManager.localizationGroupings(str);
        LocalizationAdapter localizationAdapter2 = this.adapter;
        if (localizationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            localizationAdapter = localizationAdapter2;
        }
        localizationAdapter.updateData(this.rowModels);
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (str == null) {
            return true;
        }
        LocalizationManager localizationManager = this.localizationManager;
        LocalizationAdapter localizationAdapter = null;
        if (localizationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localizationManager");
            localizationManager = null;
        }
        this.rowModels = localizationManager.localizationGroupings(str);
        LocalizationAdapter localizationAdapter2 = this.adapter;
        if (localizationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            localizationAdapter = localizationAdapter2;
        }
        localizationAdapter.updateData(this.rowModels);
        return true;
    }
}
