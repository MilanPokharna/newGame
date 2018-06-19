// Generated code from Butter Knife. Do not modify!
package com.lenovo.newgame.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.lenovo.newgame.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.simpleProgressBar = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar, "field 'simpleProgressBar'", RoundCornerProgressBar.class);
    target.simpleProgressBar2 = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar2, "field 'simpleProgressBar2'", RoundCornerProgressBar.class);
    target.simpleProgressBar3 = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar3, "field 'simpleProgressBar3'", RoundCornerProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.simpleProgressBar = null;
    target.simpleProgressBar2 = null;
    target.simpleProgressBar3 = null;
  }
}
