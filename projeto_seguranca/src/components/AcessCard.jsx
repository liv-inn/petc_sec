

function AcessCard({title, subtitle, icon, description, link}){

    return(
        <div className="h-80 w-80 bg-white rounded-2xl
         border-[#BBF7D0] border shadow 
         hover:shadow-lg transition
         flex flex-col items-center ">
            <h3 className="font-semibold text-blue-600 text-2xl mt-8">{title}</h3>
            <p className="text-sm text-gray-600 mb-8">{subtitle}</p>
            <span className="bg-blue-600 rounded-full w-20 h-20 flex items-center justify-center">
                {icon}
            </span>            <p className="text-sm text-gray-600 text-center m-4">{description}</p>
            <button className="bg-blue-600 w-3/4 text-white rounded-lg p-2 hover:bg-blue-700 transition-colors">
                <span className="no-underline decoration-none">{link}</span>
            </button>
        </div>
    )

}

export default AcessCard;