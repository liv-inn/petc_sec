import StatsCard from '../components/StatsCard';
import Logo from '../components/Logo.jsx';
import { FaCalendar, FaDog, FaPlus, FaUser } from 'react-icons/fa6';
import SearchBar from '../components/searchBar.jsx';

function Home(){
    const handleClick = () => {
        console.log('Botão Cadastrar clicado');
    };

    return (
        <div className="home">
            <div className='bg-white h-16 w-full flex items-center justify-between border border-gray-200 mb-8 px-8'>
  <div className='flex items-center gap-2'>
    <Logo className='text-blue-600 text-2xl' />
    <p className='mt-1 text-gray-500'>Dashboard</p>
  </div>

  <div className='flex items-center gap-8'>
    <p className='text-gray-600 mt-1'>Olá, user</p>
    <button className='border border-gray-300 h-8 w-18 text-sm rounded text-gray-600'>Sair</button>
  </div>
</div>
            <div className='flex gap-20  justify-center  '>
                <StatsCard 
                title="Total de Pets"
                value="10"
                icon={ <FaDog /> }
                />

                <StatsCard 
                title="Consultas"
                value="3"
                icon={ <FaCalendar/> }
                />

                <StatsCard 
                title="Donos Cadastrados"
                value="80"
                icon={ <FaUser/> }
                />
            </div>

      <div className="flex flex-col sm:flex-row gap-4 mb-6 items-center">
      <div className="flex-1 w-full">
        <SearchBar />
      </div>
      <button
        onClick={handleClick}
        className="w-48 h-12 bg-blue-700 text-white rounded-sm flex gap-2 justify-center items-center mt-8 mr-24 hover:bg-blue-800 transition-colors duration-300 shadow-md"
      >
        <FaPlus /> Cadastrar
      </button>
    </div>
    </div>
    )
}

export default Home;