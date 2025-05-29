import Logo from './Logo';

function LogoForm({subtitle}){

    return(
       
        <div>
            <Logo className="text-3xl text-blue-600 font-medium mt-8" />
            <p className="text-sm text-gray-600">{subtitle}</p>
         </div>
        
     
    )
}

export default LogoForm;