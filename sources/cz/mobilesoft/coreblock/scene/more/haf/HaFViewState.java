package cz.mobilesoft.coreblock.scene.more.haf;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.dto.CategoryDTO;
import cz.mobilesoft.coreblock.dto.HaFQuestionResponse;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HaFViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f107628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewModelState f107629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CategoryDTO f107630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HaFQuestionResponse f107631d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final QuestionDTO f107632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f107633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f107634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f107635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewModelState f107636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HaFQuestionResponse f107637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f107638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f107639m;

    public HaFViewState(List categories, ViewModelState downloadState, CategoryDTO categoryDTO, HaFQuestionResponse haFQuestionResponse, QuestionDTO questionDTO, boolean z2, String query, List list, ViewModelState searchState, HaFQuestionResponse haFQuestionResponse2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(downloadState, "downloadState");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchState, "searchState");
        this.f107628a = categories;
        this.f107629b = downloadState;
        this.f107630c = categoryDTO;
        this.f107631d = haFQuestionResponse;
        this.f107632f = questionDTO;
        this.f107633g = z2;
        this.f107634h = query;
        this.f107635i = list;
        this.f107636j = searchState;
        this.f107637k = haFQuestionResponse2;
        this.f107638l = z3;
        this.f107639m = z4;
    }

    public static /* synthetic */ HaFViewState b(HaFViewState haFViewState, List list, ViewModelState viewModelState, CategoryDTO categoryDTO, HaFQuestionResponse haFQuestionResponse, QuestionDTO questionDTO, boolean z2, String str, List list2, ViewModelState viewModelState2, HaFQuestionResponse haFQuestionResponse2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = haFViewState.f107628a;
        }
        if ((i3 & 2) != 0) {
            viewModelState = haFViewState.f107629b;
        }
        if ((i3 & 4) != 0) {
            categoryDTO = haFViewState.f107630c;
        }
        if ((i3 & 8) != 0) {
            haFQuestionResponse = haFViewState.f107631d;
        }
        if ((i3 & 16) != 0) {
            questionDTO = haFViewState.f107632f;
        }
        if ((i3 & 32) != 0) {
            z2 = haFViewState.f107633g;
        }
        if ((i3 & 64) != 0) {
            str = haFViewState.f107634h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            list2 = haFViewState.f107635i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            viewModelState2 = haFViewState.f107636j;
        }
        if ((i3 & 512) != 0) {
            haFQuestionResponse2 = haFViewState.f107637k;
        }
        if ((i3 & 1024) != 0) {
            z3 = haFViewState.f107638l;
        }
        if ((i3 & 2048) != 0) {
            z4 = haFViewState.f107639m;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        ViewModelState viewModelState3 = viewModelState2;
        HaFQuestionResponse haFQuestionResponse3 = haFQuestionResponse2;
        String str2 = str;
        List list3 = list2;
        QuestionDTO questionDTO2 = questionDTO;
        boolean z7 = z2;
        return haFViewState.a(list, viewModelState, categoryDTO, haFQuestionResponse, questionDTO2, z7, str2, list3, viewModelState3, haFQuestionResponse3, z5, z6);
    }

    public final HaFViewState a(List categories, ViewModelState downloadState, CategoryDTO categoryDTO, HaFQuestionResponse haFQuestionResponse, QuestionDTO questionDTO, boolean z2, String query, List list, ViewModelState searchState, HaFQuestionResponse haFQuestionResponse2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(downloadState, "downloadState");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchState, "searchState");
        return new HaFViewState(categories, downloadState, categoryDTO, haFQuestionResponse, questionDTO, z2, query, list, searchState, haFQuestionResponse2, z3, z4);
    }

    public final List c() {
        return this.f107628a;
    }

    public final CategoryDTO d() {
        return this.f107630c;
    }

    public final HaFQuestionResponse e() {
        return this.f107631d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HaFViewState)) {
            return false;
        }
        HaFViewState haFViewState = (HaFViewState) obj;
        return Intrinsics.areEqual(this.f107628a, haFViewState.f107628a) && Intrinsics.areEqual(this.f107629b, haFViewState.f107629b) && Intrinsics.areEqual(this.f107630c, haFViewState.f107630c) && Intrinsics.areEqual(this.f107631d, haFViewState.f107631d) && Intrinsics.areEqual(this.f107632f, haFViewState.f107632f) && this.f107633g == haFViewState.f107633g && Intrinsics.areEqual(this.f107634h, haFViewState.f107634h) && Intrinsics.areEqual(this.f107635i, haFViewState.f107635i) && Intrinsics.areEqual(this.f107636j, haFViewState.f107636j) && Intrinsics.areEqual(this.f107637k, haFViewState.f107637k) && this.f107638l == haFViewState.f107638l && this.f107639m == haFViewState.f107639m;
    }

    public final QuestionDTO f() {
        Object obj;
        List list = this.f107628a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((CategoryDTO) it.next()).c());
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
            QuestionDTO questionDTO = (QuestionDTO) obj;
            HaFQuestionResponse haFQuestionResponse = this.f107631d;
            if (haFQuestionResponse != null && questionDTO.a() == haFQuestionResponse.b()) {
                break;
            }
        }
        return (QuestionDTO) obj;
    }

    public final ViewModelState g() {
        return this.f107629b;
    }

    public final HaFQuestionResponse h() {
        return this.f107637k;
    }

    public int hashCode() {
        int iHashCode = ((this.f107628a.hashCode() * 31) + this.f107629b.hashCode()) * 31;
        CategoryDTO categoryDTO = this.f107630c;
        int iHashCode2 = (iHashCode + (categoryDTO == null ? 0 : categoryDTO.hashCode())) * 31;
        HaFQuestionResponse haFQuestionResponse = this.f107631d;
        int iHashCode3 = (iHashCode2 + (haFQuestionResponse == null ? 0 : haFQuestionResponse.hashCode())) * 31;
        QuestionDTO questionDTO = this.f107632f;
        int iHashCode4 = (((((iHashCode3 + (questionDTO == null ? 0 : questionDTO.hashCode())) * 31) + Boolean.hashCode(this.f107633g)) * 31) + this.f107634h.hashCode()) * 31;
        List list = this.f107635i;
        int iHashCode5 = (((iHashCode4 + (list == null ? 0 : list.hashCode())) * 31) + this.f107636j.hashCode()) * 31;
        HaFQuestionResponse haFQuestionResponse2 = this.f107637k;
        return ((((iHashCode5 + (haFQuestionResponse2 != null ? haFQuestionResponse2.hashCode() : 0)) * 31) + Boolean.hashCode(this.f107638l)) * 31) + Boolean.hashCode(this.f107639m);
    }

    public final QuestionDTO i() {
        return this.f107632f;
    }

    public final String j() {
        return this.f107634h;
    }

    public final QuestionDTO k(String str) {
        Object obj;
        List list = this.f107628a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((CategoryDTO) it.next()).c());
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
            if (Intrinsics.areEqual(((QuestionDTO) obj).b(), str)) {
                break;
            }
        }
        return (QuestionDTO) obj;
    }

    public final ViewModelState l() {
        return this.f107636j;
    }

    public final List m() {
        return this.f107635i;
    }

    public final boolean n() {
        return this.f107639m;
    }

    public String toString() {
        return "HaFViewState(categories=" + this.f107628a + ", downloadState=" + this.f107629b + ", chosenCategory=" + this.f107630c + ", chosenQuestion=" + this.f107631d + ", previousQuestion=" + this.f107632f + ", alreadyVisitedHaF=" + this.f107633g + ", query=" + this.f107634h + ", searchedQuestions=" + this.f107635i + ", searchState=" + this.f107636j + ", presetQuestion=" + this.f107637k + ", isLeaving=" + this.f107638l + ", isChatbotEnabled=" + this.f107639m + ")";
    }

    public /* synthetic */ HaFViewState(List list, ViewModelState viewModelState, CategoryDTO categoryDTO, HaFQuestionResponse haFQuestionResponse, QuestionDTO questionDTO, boolean z2, String str, List list2, ViewModelState viewModelState2, HaFQuestionResponse haFQuestionResponse2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? Loading.f127895a : viewModelState, (i3 & 4) != 0 ? null : categoryDTO, (i3 & 8) != 0 ? null : haFQuestionResponse, (i3 & 16) != 0 ? null : questionDTO, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? "" : str, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : list2, (i3 & Function.MAX_NARGS) != 0 ? Success.f128020a : viewModelState2, (i3 & 512) == 0 ? haFQuestionResponse2 : null, (i3 & 1024) != 0 ? false : z3, (i3 & 2048) != 0 ? false : z4);
    }
}
