import Logo from '../components/Logo.jsx';
import AcessCard from '../components/AcessCard.jsx';
import { FaUserDoctor, FaUserPlus } from 'react-icons/fa6';
import { Link } from 'react-router-dom';

function LandingPage(){
    return(
        <div className='flex justify-center items-center h-screen flex-col'>
            <Logo  className="text-5xl font-bold text-gray-800"/> 
            <p className=' text-xl text-gray-600 mt-4 h-14 w-160 text-center'>Sistema completo de gestão veterinária para cuidar dos seus pets com carinho e profissionalismo</p>

            <div className='flex justify-center items-center gap-10 mt-10'>
                <AcessCard 
                title="Login"
                subtitle="Acesse sua conta já existente"
                icon={<FaUserDoctor className="text-6xl text-white" />}
                description="Entre com suas credenciais para gerenciar seus pets."
                link={
                    <Link to="/login" className=" ">
                        Entrar
                    </Link>
                }
                />
                
                <AcessCard 
                title="Criar Conta"
                subtitle="Cadastre-se no sistema"
                icon={<FaUserPlus className="text-6xl text-white" />}
                description="Crie sua conta para começar a usar o sistema e gerencie seus pets."
                                link={
                    <Link to="/cadastro" className=" ">
                        Cadastrar
                    </Link>
                }
                />
                </div>
            </div>
    
    )
}

export default LandingPage;