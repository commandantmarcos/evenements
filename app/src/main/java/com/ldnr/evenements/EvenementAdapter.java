package com.ldnr.evenements;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EvenementAdapter.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EvenementAdapter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvenementAdapter extends FragmentPagerAdapter {

    public EvenementAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return(com.example.silver.myproject.EvenementFragment.newInstance());
            case 1: return(com.example.silver.myproject.GroupeFragment.newInstance());
            default: return(com.example.silver.myproject.EvenementFragment.newInstance());
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    //  public EvenementAdapter(FragmentManager fragmentManager){
    //      super(fragmentManager);
    //  }

    //  @Override
    //  public Fragment getItem(int position) {
    //      return ArrayListFragment.newInstance(position);
    //  }

    //  @Override
    //  public int getCount() {
    //      return 0;
    //  }

    //  public static class ArrayListFragment extends ListFragment {
    //      int mNum;

    //      /**
    //       * Create a new instance of CountingFragment, providing "num"
    //       * as an argument.
    //       */
    //      static ArrayListFragment newInstance(int num) {
    //          ArrayListFragment f = new ArrayListFragment();

    //          // Supply num input as an argument.
    //          Bundle args = new Bundle();
    //          args.putInt("num", num);
    //          f.setArguments(args);

    //          return f;
    //      }

    //      /**
    //       * When creating, retrieve this instance's number from its arguments.
    //       */
    //      @Override
    //      public void onCreate(Bundle savedInstanceState) {
    //          super.onCreate(savedInstanceState);
    //          mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    //      }

    //      /**
    //       * The Fragment's UI is just a simple text view showing its
    //       * instance number.
    //       */
    //      @Override
    //      public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //                               Bundle savedInstanceState) {
    //          View v = inflater.inflate(R.layout., container, false);
    //          View tv = v.findViewById(R.id.text);
    //          ((TextView)tv).setText("Fragment #" + mNum);
    //          return v;
    //      }

    //      @Override
    //      public void onActivityCreated(Bundle savedInstanceState) {
    //          super.onActivityCreated(savedInstanceState);
    //          setListAdapter(new ArrayAdapter<String>(getActivity(),
    //                  android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
    //      }

    //      @Override
    //      public void onListItemClick(ListView l, View v, int position, long id) {
    //          Log.i("FragmentList", "Item clicked: " + id);
    //      }
    //  }
}
