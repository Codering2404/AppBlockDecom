package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.tooling.PreviewUtils_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.data.CallGroup;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AnimationSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f29808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f29809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TransitionSearch f29810c = new TransitionSearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$transitionSearch$1
        {
            super(1);
        }

        public final void c(Transition transition) {
            ((PreviewAnimationClock) this.f29833a.f29808a.invoke()).s(transition);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Transition) obj);
            return Unit.f139807a;
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatedContentSearch f29811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatedVisibilitySearch f29812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f29813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f29814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f29815h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimateContentSizeSearch extends Search<Object> {
        public AnimateContentSizeSearch(Function1 function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : collection) {
                if (!((Group) obj).e().isEmpty()) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                Iterator it = ((Group) obj2).e().iterator();
                while (it.hasNext()) {
                    ((ModifierInfo) it.next()).a().any(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$AnimateContentSizeSearch$addAnimations$2$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final Boolean invoke(Modifier.Element element) {
                            boolean z2;
                            if (Intrinsics.areEqual(element.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement")) {
                                this.f29816a.b().add(element);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            return Boolean.valueOf(z2);
                        }
                    });
                }
            }
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            if (group.e().isEmpty()) {
                return false;
            }
            List listE = group.e();
            if ((listE instanceof Collection) && listE.isEmpty()) {
                return false;
            }
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                if (((ModifierInfo) it.next()).a().any(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$AnimateContentSizeSearch$hasAnimation$1$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(Modifier.Element element) {
                        return Boolean.valueOf(Intrinsics.areEqual(element.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement"));
                    }
                })) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimateXAsStateSearch extends Search<AnimateXAsStateSearchInfo<?, ?>> {
        public AnimateXAsStateSearch(Function1 function1) {
            super(function1);
        }

        private final Animatable f(CallGroup callGroup) {
            Object next;
            List listEmptyList;
            Object next2;
            Object next3;
            Iterator it = callGroup.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof Animatable) {
                    break;
                }
            }
            if (!(next instanceof Animatable)) {
                next = null;
            }
            Animatable animatable = (Animatable) next;
            if (animatable == null || (listEmptyList = CollectionsKt.listOf(animatable)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            Collection collectionB = callGroup.b();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((Group) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (next3 instanceof Animatable) {
                        break;
                    }
                }
                if (!(next3 instanceof Animatable)) {
                    next3 = null;
                }
                Animatable animatable2 = (Animatable) next3;
                if (animatable2 != null) {
                    arrayList.add(animatable2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = collectionB.iterator();
            while (it4.hasNext()) {
                Group groupE = PreviewUtils_androidKt.e((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.f29837a);
                if (groupE != null) {
                    arrayList2.add(groupE);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                Iterator it5 = ((Group) obj).c().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it5.next();
                    if (next2 instanceof Animatable) {
                        break;
                    }
                }
                if (!(next2 instanceof Animatable)) {
                    next2 = null;
                }
                Animatable animatable3 = (Animatable) next2;
                if (animatable3 != null) {
                    arrayList3.add(animatable3);
                }
            }
            return (Animatable) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList3)));
        }

        private final AnimationSpec g(CallGroup callGroup) {
            Collection collectionB = callGroup.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionB) {
                if (Intrinsics.areEqual(((Group) obj).f(), "rememberUpdatedState")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                CollectionsKt.addAll(arrayList2, ((Group) obj2).b());
            }
            List listPlus = CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList3, ((Group) it.next()).c());
            }
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList3.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj3 = arrayList3.get(i5);
                i5++;
                if (obj3 instanceof State) {
                    arrayList4.add(obj3);
                }
            }
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            int size3 = arrayList4.size();
            int i6 = 0;
            while (i6 < size3) {
                Object obj4 = arrayList4.get(i6);
                i6++;
                arrayList5.add(((State) obj4).getValue());
            }
            ArrayList arrayList6 = new ArrayList();
            int size4 = arrayList5.size();
            while (i3 < size4) {
                Object obj5 = arrayList5.get(i3);
                i3++;
                if (obj5 instanceof AnimationSpec) {
                    arrayList6.add(obj5);
                }
            }
            return (AnimationSpec) CollectionsKt.firstOrNull((List) arrayList6);
        }

        private final List h(Collection collection) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                CallGroup callGroupJ = j((Group) it.next());
                if (callGroupJ != null) {
                    arrayList.add(callGroupJ);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                CallGroup callGroup = (CallGroup) obj;
                Animatable animatableF = f(callGroup);
                AnimationSpec animationSpecG = g(callGroup);
                MutableState mutableStateI = i(callGroup);
                AnimateXAsStateSearchInfo animateXAsStateSearchInfo = null;
                animateXAsStateSearchInfo = null;
                animateXAsStateSearchInfo = null;
                if (animatableF != null && animationSpecG != null && mutableStateI != null) {
                    if (mutableStateI.getValue() == null) {
                        mutableStateI.setValue(new ToolingState(animatableF.n()));
                    }
                    Object value = mutableStateI.getValue();
                    ToolingState toolingState = value instanceof ToolingState ? (ToolingState) value : null;
                    if (toolingState == null) {
                        toolingState = new ToolingState(animatableF.n());
                    }
                    animateXAsStateSearchInfo = new AnimateXAsStateSearchInfo(animatableF, animationSpecG, toolingState);
                }
                if (animateXAsStateSearchInfo != null) {
                    arrayList2.add(animateXAsStateSearchInfo);
                }
            }
            return arrayList2;
        }

        private final MutableState i(Group group) {
            Object next;
            List listEmptyList;
            Object next2;
            Object next3;
            Iterator it = group.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof MutableState) {
                    break;
                }
            }
            if (!(next instanceof MutableState)) {
                next = null;
            }
            MutableState mutableState = (MutableState) next;
            if (mutableState == null || (listEmptyList = CollectionsKt.listOf(mutableState)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            Collection collectionB = group.b();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((Group) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (next3 instanceof MutableState) {
                        break;
                    }
                }
                if (!(next3 instanceof MutableState)) {
                    next3 = null;
                }
                MutableState mutableState2 = (MutableState) next3;
                if (mutableState2 != null) {
                    arrayList.add(mutableState2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = collectionB.iterator();
            while (it4.hasNext()) {
                Group groupE = PreviewUtils_androidKt.e((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.f29837a);
                if (groupE != null) {
                    arrayList2.add(groupE);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                Iterator it5 = ((Group) obj).c().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it5.next();
                    if (next2 instanceof MutableState) {
                        break;
                    }
                }
                if (!(next2 instanceof MutableState)) {
                    next2 = null;
                }
                MutableState mutableState3 = (MutableState) next2;
                if (mutableState3 != null) {
                    arrayList3.add(mutableState3);
                }
            }
            return (MutableState) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList3)));
        }

        private final CallGroup j(Group group) {
            if (group.d() == null || !Intrinsics.areEqual(group.f(), "animateValueAsState")) {
                group = null;
            }
            if (group == null || !(group instanceof CallGroup)) {
                return null;
            }
            return (CallGroup) group;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            b().addAll(h(collection));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            CallGroup callGroupJ = j(group);
            return (callGroupJ == null || f(callGroupJ) == null || g(callGroupJ) == null || i(callGroupJ) == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimateXAsStateSearchInfo<T, V extends AnimationVector> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f29818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AnimationSpec f29819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ToolingState f29820c;

        public AnimateXAsStateSearchInfo(Animatable animatable, AnimationSpec animationSpec, ToolingState toolingState) {
            this.f29818a = animatable;
            this.f29819b = animationSpec;
            this.f29820c = toolingState;
        }

        public final Animatable a() {
            return this.f29818a;
        }

        public final AnimationSpec b() {
            return this.f29819b;
        }

        public final ToolingState c() {
            return this.f29820c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimateXAsStateSearchInfo)) {
                return false;
            }
            AnimateXAsStateSearchInfo animateXAsStateSearchInfo = (AnimateXAsStateSearchInfo) obj;
            return Intrinsics.areEqual(this.f29818a, animateXAsStateSearchInfo.f29818a) && Intrinsics.areEqual(this.f29819b, animateXAsStateSearchInfo.f29819b) && Intrinsics.areEqual(this.f29820c, animateXAsStateSearchInfo.f29820c);
        }

        public int hashCode() {
            return (((this.f29818a.hashCode() * 31) + this.f29819b.hashCode()) * 31) + this.f29820c.hashCode();
        }

        public String toString() {
            return "AnimateXAsStateSearchInfo(animatable=" + this.f29818a + ", animationSpec=" + this.f29819b + ", toolingState=" + this.f29820c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimatedContentSearch extends Search<Transition<?>> {
        public AnimatedContentSearch(Function1 function1) {
            super(function1);
        }

        private final Group f(Group group) {
            Object obj = null;
            if (group.d() == null || !Intrinsics.areEqual(group.f(), "AnimatedContent")) {
                group = null;
            }
            if (group == null) {
                return null;
            }
            Iterator it = group.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((Group) next).f(), "updateTransition")) {
                    obj = next;
                    break;
                }
            }
            return (Group) obj;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Group groupF = f((Group) it.next());
                if (groupF != null) {
                    arrayList.add(groupF);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                Iterator it2 = ((Group) obj).c().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it2.next();
                        if (next2 instanceof Transition) {
                            break;
                        }
                    }
                }
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList2.add(transition);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList.get(i5);
                i5++;
                Group groupE = PreviewUtils_androidKt.e((Group) obj2, AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.f29837a);
                if (groupE != null) {
                    arrayList3.add(groupE);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList3.size();
            while (i3 < size3) {
                Object obj3 = arrayList3.get(i3);
                i3++;
                Iterator it3 = ((Group) obj3).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it3.next();
                        if (next instanceof Transition) {
                            break;
                        }
                    }
                }
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList4.add(transition2);
                }
            }
            setB.addAll(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            return f(group) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimatedVisibilitySearch extends Search<Transition<?>> {
        public AnimatedVisibilitySearch(Function1 function1) {
            super(function1);
        }

        private final Group f(Group group) {
            Object obj = null;
            if (group.d() == null || !Intrinsics.areEqual(group.f(), "AnimatedVisibility")) {
                group = null;
            }
            if (group == null) {
                return null;
            }
            Iterator it = group.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((Group) next).f(), "updateTransition")) {
                    obj = next;
                    break;
                }
            }
            return (Group) obj;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Group groupF = f((Group) it.next());
                if (groupF != null) {
                    arrayList.add(groupF);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                Iterator it2 = ((Group) obj).c().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it2.next();
                        if (next2 instanceof Transition) {
                            break;
                        }
                    }
                }
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList2.add(transition);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList.get(i5);
                i5++;
                Group groupE = PreviewUtils_androidKt.e((Group) obj2, AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.f29837a);
                if (groupE != null) {
                    arrayList3.add(groupE);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList3.size();
            while (i3 < size3) {
                Object obj3 = arrayList3.get(i3);
                i3++;
                Iterator it3 = ((Group) obj3).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it3.next();
                        if (next instanceof Transition) {
                            break;
                        }
                    }
                }
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList4.add(transition2);
                }
            }
            setB.addAll(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            return f(group) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DecaySearch extends RememberSearch<DecayAnimation<?, ?>> {
        public DecaySearch(Function1 function1) {
            super(Reflection.b(DecayAnimation.class), function1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InfiniteTransitionSearch extends Search<InfiniteTransitionSearchInfo> {
        public InfiniteTransitionSearch(Function1 function1) {
            super(function1);
        }

        private final List f(Collection collection) {
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo;
            Object next;
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                CallGroup callGroupH = h((Group) it.next());
                if (callGroupH != null) {
                    arrayList.add(callGroupH);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                CallGroup callGroup = (CallGroup) obj;
                Collection collectionC = callGroup.c();
                Collection collectionB = callGroup.b();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = collectionB.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(arrayList3, ((Group) it2.next()).c());
                }
                Iterator it3 = CollectionsKt.plus(collectionC, (Iterable) arrayList3).iterator();
                while (true) {
                    infiniteTransitionSearchInfo = null;
                    infiniteTransitionSearchInfo = null;
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    if (next instanceof InfiniteTransition) {
                        break;
                    }
                }
                if (!(next instanceof InfiniteTransition)) {
                    next = null;
                }
                InfiniteTransition infiniteTransition = (InfiniteTransition) next;
                MutableState mutableStateG = g(callGroup);
                if (infiniteTransition != null && mutableStateG != null) {
                    if (mutableStateG.getValue() == null) {
                        mutableStateG.setValue(new ToolingState(0L));
                    }
                    Object value = mutableStateG.getValue();
                    ToolingState toolingState = value instanceof ToolingState ? (ToolingState) value : null;
                    if (toolingState == null) {
                        toolingState = new ToolingState(0L);
                    }
                    infiniteTransitionSearchInfo = new InfiniteTransitionSearchInfo(infiniteTransition, toolingState);
                }
                if (infiniteTransitionSearchInfo != null) {
                    arrayList2.add(infiniteTransitionSearchInfo);
                }
            }
            return arrayList2;
        }

        private final MutableState g(Group group) {
            Object next;
            Collection collectionC = group.c();
            Collection collectionB = group.b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionB.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Group) it.next()).b());
            }
            List listPlus = CollectionsKt.plus(collectionB, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = listPlus.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((Group) it2.next()).c());
            }
            Iterator it3 = CollectionsKt.plus(collectionC, (Iterable) arrayList2).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                if (next instanceof MutableState) {
                    break;
                }
            }
            return (MutableState) (next instanceof MutableState ? next : null);
        }

        private final CallGroup h(Group group) {
            if (group.d() == null || !Intrinsics.areEqual(group.f(), "rememberInfiniteTransition")) {
                group = null;
            }
            if (group == null || !(group instanceof CallGroup)) {
                return null;
            }
            return (CallGroup) group;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            b().addAll(f(collection));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            Object next;
            if (h(group) != null) {
                Collection collectionC = group.c();
                Collection collectionB = group.b();
                ArrayList arrayList = new ArrayList();
                Iterator it = collectionB.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((Group) it.next()).c());
                }
                Iterator it2 = CollectionsKt.plus(collectionC, (Iterable) arrayList).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (next instanceof InfiniteTransition) {
                        break;
                    }
                }
                if (((InfiniteTransition) (next instanceof InfiniteTransition ? next : null)) != null && g(group) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InfiniteTransitionSearchInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f29821c = InfiniteTransition.f3967f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InfiniteTransition f29822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ToolingState f29823b;

        public InfiniteTransitionSearchInfo(InfiniteTransition infiniteTransition, ToolingState toolingState) {
            this.f29822a = infiniteTransition;
            this.f29823b = toolingState;
        }

        public final InfiniteTransition a() {
            return this.f29822a;
        }

        public final ToolingState b() {
            return this.f29823b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InfiniteTransitionSearchInfo)) {
                return false;
            }
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo = (InfiniteTransitionSearchInfo) obj;
            return Intrinsics.areEqual(this.f29822a, infiniteTransitionSearchInfo.f29822a) && Intrinsics.areEqual(this.f29823b, infiniteTransitionSearchInfo.f29823b);
        }

        public int hashCode() {
            return (this.f29822a.hashCode() * 31) + this.f29823b.hashCode();
        }

        public String toString() {
            return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.f29822a + ", toolingState=" + this.f29823b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class RememberSearch<T> extends Search<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final KClass f29824c;

        public RememberSearch(KClass kClass, Function1 function1) {
            super(function1);
            this.f29824c = kClass;
        }

        private final Object f(Group group, KClass kClass) {
            Object obj;
            Iterator<T> it = group.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (Intrinsics.areEqual(next != null ? JvmClassMappingKt.c(next.getClass()) : null, kClass)) {
                    obj = next;
                    break;
                }
            }
            return KClasses.b(kClass, obj);
        }

        private final List g(Collection collection, KClass kClass) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                Object objF = f((Group) it.next(), kClass);
                if (objF != null) {
                    arrayList.add(objF);
                }
            }
            return arrayList;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            ArrayList arrayList = new ArrayList();
            for (T t2 : collection) {
                if (((Group) t2).d() != null) {
                    arrayList.add(t2);
                }
            }
            b().addAll(CollectionsKt.toSet(g(arrayList, this.f29824c)));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            return (group.d() == null || f(group, this.f29824c) == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TargetBasedSearch extends RememberSearch<TargetBasedAnimation<?, ?>> {
        public TargetBasedSearch(Function1 function1) {
            super(Reflection.b(TargetBasedAnimation.class), function1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransitionSearch extends Search<Transition<?>> {
        public TransitionSearch(Function1 function1) {
            super(function1);
        }

        private final Group f(Group group) {
            if (group.d() == null || !Intrinsics.areEqual(group.f(), "updateTransition")) {
                return null;
            }
            return group;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Group groupF = f((Group) it.next());
                if (groupF != null) {
                    arrayList.add(groupF);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                Iterator it2 = ((Group) obj).c().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it2.next();
                        if (next2 instanceof Transition) {
                            break;
                        }
                    }
                }
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList2.add(transition);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList.get(i5);
                i5++;
                Group groupE = PreviewUtils_androidKt.e((Group) obj2, AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.f29837a);
                if (groupE != null) {
                    arrayList3.add(groupE);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList3.size();
            while (i3 < size3) {
                Object obj3 = arrayList3.get(i3);
                i3++;
                Iterator it3 = ((Group) obj3).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it3.next();
                        if (next instanceof Transition) {
                            break;
                        }
                    }
                }
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList4.add(transition2);
                }
            }
            setB.addAll(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean c(Group group) {
            return f(group) != null;
        }
    }

    public AnimationSearch(Function0 function0, Function0 function02) {
        this.f29808a = function0;
        this.f29809b = function02;
        AnimatedContentSearch animatedContentSearch = new AnimatedContentSearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animatedContentSearch$1
            {
                super(1);
            }

            public final void c(Transition transition) {
                ((PreviewAnimationClock) this.f29828a.f29808a.invoke()).m(transition);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Transition) obj);
                return Unit.f139807a;
            }
        });
        this.f29811d = animatedContentSearch;
        this.f29812e = new AnimatedVisibilitySearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animatedVisibilitySearch$1
            {
                super(1);
            }

            public final void c(Transition transition) {
                ((PreviewAnimationClock) this.f29829a.f29808a.invoke()).n(transition, this.f29829a.f29809b);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Transition) obj);
                return Unit.f139807a;
            }
        });
        Set setG = g();
        this.f29813f = setG;
        Set setPlus = SetsKt.plus(setG, (Iterable) h());
        this.f29814g = setPlus;
        this.f29815h = SetsKt.plus(setPlus, (Iterable) SetsKt.setOf(animatedContentSearch));
    }

    private final Collection c() {
        return AnimateXAsStateComposeAnimation.f29788g.a() ? SetsKt.setOf(new AnimateXAsStateSearch(new Function1<AnimateXAsStateSearchInfo<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animateXAsStateSearch$1
            {
                super(1);
            }

            public final void c(AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo) {
                ((PreviewAnimationClock) this.f29827a.f29808a.invoke()).l(animateXAsStateSearchInfo);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AnimationSearch.AnimateXAsStateSearchInfo) obj);
                return Unit.f139807a;
            }
        })) : CollectionsKt.emptyList();
    }

    private final Set e() {
        return InfiniteTransitionComposeAnimation.f29838f.a() ? SetsKt.setOf(new InfiniteTransitionSearch(new Function1<InfiniteTransitionSearchInfo, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$infiniteTransitionSearch$1
            {
                super(1);
            }

            public final void c(AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo) {
                ((PreviewAnimationClock) this.f29831a.f29808a.invoke()).q(infiniteTransitionSearchInfo);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AnimationSearch.InfiniteTransitionSearchInfo) obj);
                return Unit.f139807a;
            }
        })) : SetsKt.emptySet();
    }

    private final Set g() {
        return SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf((Object[]) new Search[]{this.f29810c, this.f29812e}), (Iterable) c()), (Iterable) e()), (Iterable) (AnimatedContentComposeAnimation.f29797e.a() ? SetsKt.setOf(this.f29811d) : SetsKt.emptySet()));
    }

    private final Collection h() {
        return UnsupportedComposeAnimation.f29878e.b() ? SetsKt.setOf((Object[]) new Search[]{new AnimateContentSizeSearch(new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$1
            {
                super(1);
            }

            public final void c(Object obj) {
                ((PreviewAnimationClock) this.f29834a.f29808a.invoke()).k(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        }), new TargetBasedSearch(new Function1<TargetBasedAnimation<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$2
            {
                super(1);
            }

            public final void c(TargetBasedAnimation targetBasedAnimation) {
                ((PreviewAnimationClock) this.f29835a.f29808a.invoke()).r(targetBasedAnimation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TargetBasedAnimation) obj);
                return Unit.f139807a;
            }
        }), new DecaySearch(new Function1<DecayAnimation<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$3
            {
                super(1);
            }

            public final void c(DecayAnimation decayAnimation) {
                ((PreviewAnimationClock) this.f29836a.f29808a.invoke()).p(decayAnimation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DecayAnimation) obj);
                return Unit.f139807a;
            }
        })}) : CollectionsKt.emptyList();
    }

    public final void d(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            List listB = PreviewUtils_androidKt.b((Group) it.next(), new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$attachAllAnimations$1$groups$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Group group) {
                    return Boolean.TRUE;
                }
            });
            Iterator it2 = this.f29815h.iterator();
            while (it2.hasNext()) {
                ((Search) it2.next()).a(listB);
            }
            this.f29810c.b().removeAll(this.f29812e.b());
            this.f29810c.b().removeAll(this.f29811d.b());
        }
        Iterator it3 = this.f29814g.iterator();
        while (it3.hasNext()) {
            ((Search) it3.next()).e();
        }
    }

    public final boolean f(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return false;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            List listB = PreviewUtils_androidKt.b((Group) it.next(), new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$searchAny$1$groups$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Group group) {
                    return Boolean.TRUE;
                }
            });
            Set set = this.f29813f;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (((Search) it2.next()).d(listB)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Search<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f29825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set f29826b = new LinkedHashSet();

        public Search(Function1 function1) {
            this.f29825a = function1;
        }

        public final Set b() {
            return this.f29826b;
        }

        public abstract boolean c(Group group);

        public final boolean d(Collection collection) {
            Collection collection2 = collection;
            if ((collection2 instanceof Collection) && collection2.isEmpty()) {
                return false;
            }
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                if (c((Group) it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final void e() {
            List listReversed = CollectionsKt.reversed(this.f29826b);
            Function1 function1 = this.f29825a;
            Iterator<T> it = listReversed.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
        }

        public void a(Collection collection) {
        }
    }
}
