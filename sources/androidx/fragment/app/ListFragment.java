package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ListFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f37416a = new Handler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f37417b = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f37420f;
            listView.focusableViewAvailable(listView);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f37418c = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            ListFragment.this.x((ListView) adapterView, view, i3, j3);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ListAdapter f37419d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ListView f37420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f37421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    TextView f37422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    View f37423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View f37424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    CharSequence f37425k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f37426l;

    private void w() {
        if (this.f37420f != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f37420f = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.f37422h = textView;
            if (textView == null) {
                this.f37421g = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.f37423i = view.findViewById(16711682);
            this.f37424j = view.findViewById(16711683);
            View viewFindViewById = view.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) viewFindViewById;
            this.f37420f = listView;
            View view2 = this.f37421g;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.f37425k;
                if (charSequence != null) {
                    this.f37422h.setText(charSequence);
                    this.f37420f.setEmptyView(this.f37422h);
                }
            }
        }
        this.f37426l = true;
        this.f37420f.setOnItemClickListener(this.f37418c);
        ListAdapter listAdapter = this.f37419d;
        if (listAdapter != null) {
            this.f37419d = null;
            y(listAdapter);
        } else if (this.f37423i != null) {
            z(false, false);
        }
        this.f37416a.post(this.f37417b);
    }

    private void z(boolean z2, boolean z3) {
        w();
        View view = this.f37423i;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f37426l == z2) {
            return;
        }
        this.f37426l = z2;
        if (z2) {
            if (z3) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.f37424j.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f37424j.clearAnimation();
            }
            this.f37423i.setVisibility(8);
            this.f37424j.setVisibility(0);
            return;
        }
        if (z3) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.f37424j.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f37424j.clearAnimation();
        }
        this.f37423i.setVisibility(0);
        this.f37424j.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context contextRequireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextRequireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextRequireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(contextRequireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextRequireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f37416a.removeCallbacks(this.f37417b);
        this.f37420f = null;
        this.f37426l = false;
        this.f37424j = null;
        this.f37423i = null;
        this.f37421g = null;
        this.f37422h = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        w();
    }

    public void y(ListAdapter listAdapter) {
        boolean z2 = this.f37419d != null;
        this.f37419d = listAdapter;
        ListView listView = this.f37420f;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f37426l || z2) {
                return;
            }
            z(true, requireView().getWindowToken() != null);
        }
    }

    public void x(ListView listView, View view, int i3, long j3) {
    }
}
