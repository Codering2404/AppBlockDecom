package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final FragmentManager f37210a;

    FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.f37210a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final FragmentStateManager fragmentStateManagerZ;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f37210a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f37098a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R.styleable.f37099b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.f37100c, -1);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.f37101d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentM0 = resourceId != -1 ? this.f37210a.m0(resourceId) : null;
        if (fragmentM0 == null && string != null) {
            fragmentM0 = this.f37210a.n0(string);
        }
        if (fragmentM0 == null && id != -1) {
            fragmentM0 = this.f37210a.m0(id);
        }
        if (fragmentM0 == null) {
            fragmentM0 = this.f37210a.B0().a(context.getClassLoader(), attributeValue);
            fragmentM0.mFromLayout = true;
            fragmentM0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentM0.mContainerId = id;
            fragmentM0.mTag = string;
            fragmentM0.mInLayout = true;
            FragmentManager fragmentManager = this.f37210a;
            fragmentM0.mFragmentManager = fragmentManager;
            fragmentM0.mHost = fragmentManager.E0();
            fragmentM0.onInflate(this.f37210a.E0().f(), attributeSet, fragmentM0.mSavedFragmentState);
            fragmentStateManagerZ = this.f37210a.j(fragmentM0);
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentM0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentM0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentM0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f37210a;
            fragmentM0.mFragmentManager = fragmentManager2;
            fragmentM0.mHost = fragmentManager2.E0();
            fragmentM0.onInflate(this.f37210a.E0().f(), attributeSet, fragmentM0.mSavedFragmentState);
            fragmentStateManagerZ = this.f37210a.z(fragmentM0);
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentM0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.i(fragmentM0, viewGroup);
        fragmentM0.mContainer = viewGroup;
        fragmentStateManagerZ.m();
        fragmentStateManagerZ.j();
        View view2 = fragmentM0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentM0.mView.getTag() == null) {
            fragmentM0.mView.setTag(string);
        }
        fragmentM0.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view3) {
                Fragment fragmentK = fragmentStateManagerZ.k();
                fragmentStateManagerZ.m();
                SpecialEffectsController.r((ViewGroup) fragmentK.mView.getParent(), FragmentLayoutInflaterFactory.this.f37210a).n();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view3) {
            }
        });
        return fragmentM0.mView;
    }
}
