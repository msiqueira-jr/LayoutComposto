package br.com.mauro.layoutcomposto.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.mauro.layoutcomposto.Adapters.SessaoAdapter;
import br.com.mauro.layoutcomposto.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConteudoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConteudoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConteudoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private AppBarLayout appbar;
    private TabLayout    janelas;
    private ViewPager    viewPager;
    View vista;




    private OnFragmentInteractionListener mListener;

    public ConteudoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConteudoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConteudoFragment newInstance(String param1, String param2) {
        ConteudoFragment fragment = new ConteudoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        vista = inflater.inflate(R.layout.fragment_conteudo, container, false);
        View parent = (View) container.getParent();
        if (appbar == null){

            appbar = parent.findViewById(R.id.appbar);
            janelas = new TabLayout(getActivity());
            appbar.addView(janelas);

            viewPager = vista.findViewById(R.id.ViewPageInfo);
            gerarViewPage(viewPager);
            viewPager.addOnAdapterChangeListener(new ViewPager.OnAdapterChangeListener() {
                @Override
                public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter1) {

                }
            });


            janelas.setupWithViewPager(viewPager);


        }

        return vista;



    }

    private void gerarViewPage(ViewPager viewPager) {
        SessaoAdapter adapter = new SessaoAdapter(getFragmentManager());
        adapter.addFragment(new FragmentAzul(), "Azul");
        adapter.addFragment(new FragmentVermelho(), "Vermelho");
        adapter.addFragment(new FragmentVerde(), "Verde");

        viewPager.setAdapter(adapter);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
