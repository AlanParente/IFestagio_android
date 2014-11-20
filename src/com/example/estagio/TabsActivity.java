package com.example.estagio;

import java.util.List;
import java.util.Vector;

import com.example.view.SlidingTabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class TabsActivity extends ActionBarActivity   {

	private ViewPager viewPager;
	// Titulo das abas
	private List<String> tabs;
	//Layout de abas deslizantes
	private SlidingTabLayout slidingTabLayout;
	//Adapter de Fragments
	private static MyPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
		//Instancia e adiciona títulos das abas.
		tabs = new Vector<String>();
		tabs.add("Ofertas");
		tabs.add("Hist�rico");
		tabs.add("Placeholder");
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		//Instancia o adapter utilizando o FragmentManager padrão.
		adapter = new MyPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		slidingTabLayout.setViewPager(viewPager);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	/**
	 * Classe interna do adapter de fragments.
	 * @author ruriel
	 *
	 */
	public class MyPagerAdapter extends FragmentPagerAdapter {
		private List<String> tabList;

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			tabList = tabs;
			// TODO Auto-generated constructor stub
		}

		/**
		 * Instancia a fragment de acordo com o item selecionado.
		 */
		@Override
		public Fragment getItem(int arg0) {
			Fragment fragment = null;
			switch (arg0) {
			case 0:
				fragment = Fragment.instantiate(getBaseContext(),
						OfertasFragment.class.getName());
				break;
			case 1:
				fragment = Fragment.instantiate(getBaseContext(),
						HistoricoFragment.class.getName());
				break;
			case 2:
				fragment = Fragment.instantiate(getBaseContext(),
						PlaceholderFragment.class.getName());
				break;

			}
			return fragment;
		}

		@Override
		public int getCount() {
			return tabList.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return tabList.get(position).toUpperCase();

		}

	}

}
